package xyz.stxkfzx.manager.auth.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import xyz.stxkfzx.manager.auth.entity.UserBase;
import xyz.stxkfzx.manager.auth.mapper.UserBaseMapper;
import xyz.stxkfzx.manager.auth.properties.JwtProperties;
import xyz.stxkfzx.manager.auth.utils.CodecUtils;
import xyz.stxkfzx.manager.auth.utils.JwtUtils;
import xyz.stxkfzx.manager.common.enums.UserEnum;
import xyz.stxkfzx.manager.common.pojo.FaceResult;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 授权中心的一些方法
 *
 * @author VicterTian
 * @version V1.0
 * @date 2019/4/13
 */
public interface AuthService {
    FaceResult login(String username, String password, HttpServletResponse response);
    UserBase verifyUser(String token, HttpServletResponse response);
    UserBase findUserById(Integer userId);
}
