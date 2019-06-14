package xyz.stxkfzx.manager.auth.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xyz.stxkfzx.manager.auth.entity.UserBase;
import xyz.stxkfzx.manager.auth.mapper.UserBaseMapper;
import xyz.stxkfzx.manager.auth.properties.JwtProperties;
import xyz.stxkfzx.manager.auth.service.AuthService;
import xyz.stxkfzx.manager.auth.utils.CodecUtils;
import xyz.stxkfzx.manager.auth.utils.JwtUtils;
import xyz.stxkfzx.manager.common.enums.UserEnum;
import xyz.stxkfzx.manager.common.pojo.FaceResult;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Service
public class AuthServiceImpl implements AuthService{
    private final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private final UserBaseMapper userBaseMapper;
    private final JwtProperties jwtProperties;
    private final RedisTemplate redisTemplate;

    @Autowired
    public AuthServiceImpl(JwtProperties jwtProperties, UserBaseMapper userBaseMapper, RedisTemplate redisTemplate) {
        this.jwtProperties = jwtProperties;
        this.redisTemplate = redisTemplate;
        this.userBaseMapper = userBaseMapper;
    }

    @Override
    @SuppressWarnings("unchecked")
    public FaceResult login(String username, String password, HttpServletResponse response) {

        UserBase user = userBaseMapper.selectByUsername(username);
        // 拿到用户密码利用盐值加密，并与数据库保存的加密密码进行对比
        String md5Password = CodecUtils.md5HexM(password, CodecUtils.generateSalt(user.getUsername()));
        if (!user.getPassword().equals(md5Password)) {
            logger.error("【授权中心】用户名或密码错误，用户名：{}", username);
            return new FaceResult(UserEnum.USERNAME_PASSWORD_IS_FALSE);
        }
        UserBase userBase = new UserBase(user.getUserId(), user.getUsername(), user.getStatus());
        // 生成Token
        String token = JwtUtils.generateToken(userBase, jwtProperties.getPrivateKey(), jwtProperties.getExpire());
        if (StringUtils.isBlank(token)) {
            logger.error("【授权中心】token为空");
            return new FaceResult(UserEnum.TOKEN_IS_NULL);
        }
        logger.info("【授权中心】生成token为：{}", token);
        response.setHeader("Authorization", token);
        redisTemplate.opsForValue().set(token, userBase, 30, TimeUnit.MINUTES);

        return new FaceResult().ok(userBase);
    }

    @SuppressWarnings("unchecked")
    @Override
    public UserBase verifyUser(String token, HttpServletResponse response) {
        // 先从redis中获取用户信息
        UserBase userBase = (UserBase) redisTemplate.opsForValue().get(token);
        // 如果缓存中没有，对token进行解析
        if (userBase == null) {
            synchronized (AuthService.class) {
                // 从Token中获取用户信息
                userBase = JwtUtils.getUserBase(jwtProperties.getPublicKey(), token);
                logger.warn("【授权中心】用户{}未从redis中获取信息", userBase);
                // 成功，刷新Token
                String newToken = JwtUtils.generateToken(userBase, jwtProperties.getPrivateKey(), jwtProperties.getExpire());
                // 将新的Token信息设置在Header的Authorization里,并保存在Redis中
                response.setHeader("Authorization", newToken);
                logger.warn("【授权中心】重新生成token:{}",token);
                redisTemplate.opsForValue().set(token, userBase, 30, TimeUnit.MINUTES);
            }
        }else {
            logger.warn("【授权中心】用户{}token有效", userBase);
        }
        return userBase;
    }

    /**
     * 通过id查找
     *
     * @param userId id
     * @return UserBase
     * @author ViterTian
     * @date 2019-04-14
     */
    @Override
    public UserBase findUserById(Integer userId) {
        return userBaseMapper.selectByPrimaryKey(userId);
    }
}
