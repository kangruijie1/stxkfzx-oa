package xyz.stxkfzx.manager.user.service;

import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.vo.GetAllUserRes;

import java.util.List;

public interface UserService {
    /**
     * 根据部门id查询用户
     * @param departmentId 部门id
     * @return 该部门所有用户
     */
    List<TUser> getTUsersByDepartmentId(String departmentId);

    /**
     * 获取所有用户
     * @return 用户List
     */
    List<GetAllUserRes> getAllTUser();

    /**
     * 根据用户名查询用户
     * @param username 用户名（变量名和人脸库user_info对应）
     * @return 该用户
     */
    TUser getTUserByUsername(String username);

    TUser getTUserByUserId(Integer userId);

    /**
     * 添加用户
     * @param user 用户对象
     * @return 新增用户的主键
     */
    FaceResult addUser(TUser user);

    /**
     * 判断注册的用户名是否重复
     * @param username 用户名
     * @return 是或否
     */
    Boolean checkUsernameIsRepeat(String username);

    /**
     * 更新用户密码或手机号
     * @param user 对象
     * @return FaceResult
     */
    FaceResult updateUser(TUser user);
}
