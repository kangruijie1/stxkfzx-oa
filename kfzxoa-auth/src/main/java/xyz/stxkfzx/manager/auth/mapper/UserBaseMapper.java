package xyz.stxkfzx.manager.auth.mapper;

import org.springframework.stereotype.Component;
import xyz.stxkfzx.manager.auth.entity.UserBase;

/**
 * @author VicterTian
 * @version V1.0
 * @date 2019/4/13
 */
public interface UserBaseMapper {
    /**
     * 根据主键返回UserBean
     *
     * @param userId 主键id
     * @return UserBean
     * @author ViterTian
     * @date 2019-04-13
     */
    UserBase selectByUserId(Integer userId);

    /**
     *
     *
     * @param
     * @return UserBean
     * @author ViterTian
     * @date 2019-04-13
     */
    UserBase selectUser(UserBase userBase);

    /**
     * 根据用户名返回用户
     * @param username 用户名
     * @return UserBean
     * @author ViterTian
     * @date 2019-04-13
     */
    UserBase selectByUsername(String username);


}