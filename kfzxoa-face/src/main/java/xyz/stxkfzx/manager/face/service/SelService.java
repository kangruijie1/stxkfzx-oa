package xyz.stxkfzx.manager.face.service;

import java.util.*;
import java.text.*;
import xyz.stxkfzx.manager.face.pojo.*;
import xyz.stxkfzx.manager.user.pojo.TUser;

public interface SelService
{
    List<SignItemResult> selDepartmentSignItem(int week, String group_id) throws ParseException;
    
    List<TUser> getAllUsers() throws InterruptedException;
    
    void selFaceGroupInsertUsers(final String p0) throws InterruptedException;
    
    List<Map<String, String>> exportInfo(int week, String group_id);
    
    void groupUsers(String group_id);
}
