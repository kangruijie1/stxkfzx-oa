package xyz.stxkfzx.manager.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.stxkfzx.manager.auth.entity.UserBase;
import xyz.stxkfzx.manager.auth.properties.JwtProperties;
import xyz.stxkfzx.manager.auth.service.AuthService;
import xyz.stxkfzx.manager.common.pojo.FaceResult;

import javax.servlet.http.HttpServletResponse;

/**
 * 处理授权的一些接口
 *
 * @author VicterTian
 * @version V1.0
 * @date 2019/4/13
 */
@RestController
@EnableConfigurationProperties(JwtProperties.class)
public class AuthController {
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 登录授权
     * 将token加在cookie中，并设置过期时间
     *
     * @param username 用户名
     * @param password 密码
     * @param response response
     * @return Void
     * @author ViterTian
     * @date 2019-04-13
     */
    @PostMapping("accredit")
    public FaceResult login(String username, String password, HttpServletResponse response) {
        return authService.login(username, password, response);
    }

    /**
     * 验证用户信息
     *
     * @param token 浏览器传过来的token流
     * @return ResponseEntity<UserBase>
     * @author ViterTian
     * @date 2019-04-13
     */
    @GetMapping("verify")
    public FaceResult verifyUser(@RequestHeader("Authorization") String token, HttpServletResponse response) {
        try {
            return new FaceResult().ok(authService.verifyUser(token, response));
        } catch (Exception e) {
            // Token无效
            e.printStackTrace();
            logger.error("【授权中心】Token:{}无效", token);
            return new FaceResult().fail();
        }
    }
}
