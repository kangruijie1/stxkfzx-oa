package xyz.stxkfzx.manager.face.service;

import java.util.*;

import xyz.stxkfzx.manager.face.pojo.*;
import xyz.stxkfzx.manager.user.pojo.TUser;

public interface SelSignService
{
    List<SignItemResult> selDepartmentSignItem(int week, String group_id);

    List<SignItemResult> selUserTodaySignItem(String username);

    List<SignItemResult> selUserWeekSignItem(String username, int week);
    
    List<Map<String, String>> exportInfo(int week, String group_id);
    
    void groupUsers(String group_id);
}
