package xyz.stxkfzx.manager.face.pojo;

import java.util.*;

public class GroupResult
{
    private List<String> user_id_list;
    
    public GroupResult() {
    }
    
    public GroupResult(final List<String> user_id_list) {
        this.user_id_list = user_id_list;
    }
    
    public List<String> getUser_id_list() {
        return this.user_id_list;
    }
    
    public void setUser_id_list(final List<String> user_id_list) {
        this.user_id_list = user_id_list;
    }
    
    public String toString() {
        return "GroupResult [user_id_list=" + this.user_id_list + "]";
    }
}
