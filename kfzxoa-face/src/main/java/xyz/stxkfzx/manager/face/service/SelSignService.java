package xyz.stxkfzx.manager.face.service;

import java.util.*;

import xyz.stxkfzx.manager.face.pojo.*;
import xyz.stxkfzx.manager.user.pojo.TUser;

public interface SelSignService
{
    /**
     * 查询用户当天签到记录
     * @param username 用户名
     * @return 签到结果集
     */
    List<SignItemResult> selUserTodaySignItem(String username);

    /**
     * 查询用户周签到记录
     * @param username 用户名
     * @param week 第几周
     * @return 签到结果集
     */
    List<SignItemResult> selUserWeekSignItem(String username, int week);


    /**
     * 查询部门签到记录
     * @param startTime
     * @param endTime
     * @param departmentId
     * @return
     */
    List<SignItemResult> selDepartmentSignItem(String startTime, String endTime, String departmentId);
}
