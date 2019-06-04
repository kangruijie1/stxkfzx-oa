package xyz.stxkfzx.manager.face.pojo;

import java.util.*;

public class SignItemResult
{
    private String user_info;
    private Map<String, Object> weekMap;
    
    public SignItemResult() {
    }
    
    public SignItemResult(final String user_info, final Map<String, Object> weekMap) {
        this.user_info = user_info;
        this.weekMap = weekMap;
    }
    
    public String getUser_info() {
        return this.user_info;
    }
    
    public void setUser_info(final String user_info) {
        this.user_info = user_info;
    }
    
    public Map<String, Object> getWeekMap() {
        return this.weekMap;
    }
    
    public void setWeekMap(final Map<String, Object> weekMap) {
        this.weekMap = weekMap;
    }
    
    @Override
    public String toString() {
        return "SignItemResult [user_info=" + this.user_info + ", weekMap=" + this.weekMap + "]";
    }
}
