package xyz.stxkfzx.manager.face.pojo;

import java.util.*;

public class GroupsResult
{
    private List<String> group_id_list;
    
    public GroupsResult() {
    }
    
    public GroupsResult(final List<String> group_id_list) {
        this.group_id_list = group_id_list;
    }
    
    public String toString() {
        return "GroupsResult [group_id_list=" + this.group_id_list + "]";
    }
    
    public List<String> getGroup_id_list() {
        return this.group_id_list;
    }
    
    public void setGroup_id_list(final List<String> group_id_list) {
        this.group_id_list = group_id_list;
    }
}
