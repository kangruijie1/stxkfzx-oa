package xyz.stxkfzx.manager.user.pojo;

public class TUser
{
    private int id;
    private String group_id;
    private String user_id;
    private String user_info;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getGroup_id() {
        return this.group_id;
    }
    
    public void setGroup_id(final String group_id) {
        this.group_id = group_id;
    }
    
    public String getUser_id() {
        return this.user_id;
    }
    
    public void setUser_id(final String user_id) {
        this.user_id = user_id;
    }
    
    public String getUser_info() {
        return this.user_info;
    }
    
    public void setUser_info(final String user_info) {
        this.user_info = user_info;
    }
    
    public TUser(final int id, final String group_id, final String user_id, final String user_info) {
        this.id = id;
        this.group_id = group_id;
        this.user_id = user_id;
        this.user_info = user_info;
    }
    
    public TUser() {
    }
    
    public String toString() {
        return "User [id=" + this.id + ", group_id=" + this.group_id + ", user_id=" + this.user_id + ", user_info=" + this.user_info + "]";
    }
}
