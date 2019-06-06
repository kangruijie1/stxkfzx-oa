package xyz.stxkfzx.manager.user.service;

import xyz.stxkfzx.manager.user.pojo.TUser;

import java.util.List;

public interface UserService {
    /**
     * 根据部门id查询用户
     * @param group_id 部门id
     * @return 该部门所有用户
     */
    List<TUser> getTUsersByGroupId(String group_id);

    /**
     * 获取所有用户
     * @return 用户List
     */
    List<TUser> getAllTUser();

    /**
     * 根据用户名查询用户
     * @param user_info 用户名（变量名和人脸库user_info对应）
     * @return 该用户
     */
    TUser getTUserByUserInfo(String user_info);

    /**
     * 添加用户
     * @param user 用户对象
     * @return 新增用户的主键
     */
    TUser addUser(TUser user);

    /**
     * 判断注册的用户名是否重复
     * @param username 用户名
     * @return 是或否
     */
    Boolean checkUsernameIsRepeat(String username);
}
