package xyz.stxkfzx.manager.face.pojo;

public class FaceUserResultFaceUser
{
    private String group_id;
    private String user_id;
    private String user_info;
    private String score;
    private String signMsg;
    
    public FaceUserResultFaceUser() {
    }
    
    public FaceUserResultFaceUser(final String group_id, final String user_id, final String user_info, final String score, final String signMsg) {
        this.group_id = group_id;
        this.user_id = user_id;
        this.user_info = user_info;
        this.score = score;
        this.signMsg = signMsg;
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
    
    public String getScore() {
        return this.score;
    }
    
    public void setScore(final String score) {
        this.score = score;
    }
    
    public String getSignMsg() {
        return this.signMsg;
    }
    
    public void setSignMsg(final String signMsg) {
        this.signMsg = signMsg;
    }
    
    public String toString() {
        return "FaceUserResultInfo [group_id=" + this.group_id + ", user_id=" + this.user_id + ", user_info=" + this.user_info + ", score=" + this.score + ", signMsg=" + this.signMsg + "]";
    }
}
