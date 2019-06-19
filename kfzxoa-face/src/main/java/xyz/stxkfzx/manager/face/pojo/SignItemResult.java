package xyz.stxkfzx.manager.face.pojo;

import java.util.*;

public class SignItemResult
{
    private String username;
    private Map<String, Double> dayMap;
    
    public SignItemResult() {
    }
    
    public SignItemResult(final String username, final Map<String, Double> dayMap) {
        this.username = username;
        this.dayMap = dayMap;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public Map<String, Double> getDayMap() {
        return this.dayMap;
    }
    
    public void setDayMap(final Map<String, Double> dayMap) {
        this.dayMap = dayMap;
    }
    
    @Override
    public String toString() {
        return "SignItemResult [username=" + this.username + ", dayMap=" + this.dayMap + "]";
    }
}
