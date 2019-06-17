package xyz.stxkfzx.manager.auth.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import xyz.stxkfzx.manager.auth.config.AuthConfig;
import xyz.stxkfzx.manager.auth.config.PassToken;
import xyz.stxkfzx.manager.auth.config.UserLoginToken;
import xyz.stxkfzx.manager.auth.entity.UserBase;
import xyz.stxkfzx.manager.auth.enums.AuthEnum;
import xyz.stxkfzx.manager.auth.properties.JwtProperties;
import xyz.stxkfzx.manager.auth.service.AuthService;
import xyz.stxkfzx.manager.common.enums.UserEnum;
import xyz.stxkfzx.manager.common.enums.WorkingEnum;
import xyz.stxkfzx.manager.common.myException.OAException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 授权中心拦截器
 *
 * @author VicterTian
 * @version V1.0
 * @date 2019/4/13
 */
@Order(199)
public class AuthenticationInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);
    @Autowired
    private AuthService authService;
    @Autowired
    JwtProperties jwtProperties;
    @Autowired
    AuthConfig authConfig;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("Authorization");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        // 检查是否有@PassToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        // 执行认证
        if (token == null) {
            logger.error("token为null，用户认证失败");
            throw new OAException(AuthEnum.TOKEN_IS_NULL.getMsg());
        }
        // 获取 token 中的 auth id
        UserBase userBase;
        try {
            logger.info("获取到PublicKey()");
            userBase = authService.verifyUser(token, httpServletResponse);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户认证过期");
            throw new OAException(AuthEnum.TOKEN_IS_LOW.getMsg());
        }
        UserBase user = authService.findUser(userBase);
        if (user == null) {
            logger.error("用户不存在");
            throw new OAException(UserEnum.USER_NOT_EXIST.getMsg());
        }
        //如果用户状态不为在部则无权限
        if (!user.getStatus().equals(WorkingEnum.IN_THE_DEPARTMENT.getWorkingStatusCode())){
            logger.error("用户已退部或者未激活");
            throw new OAException(AuthEnum.USER_NOT_IN_DEPARTMENT.getMsg());
        }

        //检查是否请求的是管理员方法
        if(authConfig.managerMethodList.contains(method.getName())){
            //检查用户是否为管理者
            if(authConfig.managerCodeList.contains(user.getManagerType())){
                return true;
            }else{
                logger.error("您没有权限访问此操作");
                throw new OAException(AuthEnum.NOT_AUTH_EXECUTE.getMsg());
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) {
    }
}