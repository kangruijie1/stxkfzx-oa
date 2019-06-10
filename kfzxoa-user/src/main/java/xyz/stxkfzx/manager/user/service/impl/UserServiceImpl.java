package xyz.stxkfzx.manager.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import xyz.stxkfzx.manager.auth.utils.CodecUtils;
import xyz.stxkfzx.manager.common.enums.UserEnum;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.user.mapper.UserMapper;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;
import xyz.stxkfzx.manager.user.vo.TUserVO;

import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public List<TUser> getTUsersByGroupId(String group_id) {
        TUser user = new TUser();
        user.setDepartmentId(group_id);
        List<TUser> tUsers = userMapper.selectUser(user);
        return tUsers;
    }

    @Override
    public TUser getTUserByUserInfo(String user_info) {
        TUser user = new TUser();
        user.setUsername(user_info);
        List<TUser> tUsers = userMapper.selectUser(user);
        if (!CollectionUtils.isEmpty(tUsers)) {
            return tUsers.get(0);
        }
        return null;
    }

    @Override
    public FaceResult addUser(TUser user) {
        logger.info("用户{}开始注册", user);
        // 防止用户自定义id
        user.setUserId(null);
        if (checkUsernameIsRepeat(user.getUsername())) {
            logger.info("用户名重复");
            return new FaceResult(UserEnum.USERNAME_REPEAT);
        }
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        // 生成一段盐值
        String salt = CodecUtils.generateSalt(user.getUsername());

        // 对密码进行加密
        user.setPassword(CodecUtils.md5Hex(user.getPassword(), salt));

        int i = userMapper.insertUser(user);
        if (i != 1) {
            logger.info("插入用户失败");
            return new FaceResult(UserEnum.INSERT_USER_FAIL);
        }

        TUserVO userVO = new TUserVO();
        BeanUtils.copyProperties(user, userVO);

        logger.info("用户{}注册成功", user);

        return new FaceResult().ok(userVO);
    }

    @Override
    public List<TUser> getAllTUser() {
        return userMapper.selectUser(new TUser());
    }

    @Override
    public Boolean checkUsernameIsRepeat(String username) {
        TUser user = new TUser();
        user.setUsername(username);
        return userMapper.selectUser(user) != null;
    }

}
