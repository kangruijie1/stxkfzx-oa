package xyz.stxkfzx.manager.face.pojo;

public class Groups extends FaceBasic
{
    private GroupsResult result;
    
    public Groups() {
    }
    
    public Groups(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached) {
        super(error_code, error_msg, log_id, timestamp, cached);
    }
    
    public Groups(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached, final GroupsResult result) {
        super(error_code, error_msg, log_id, timestamp, cached);
        this.result = result;
    }
    
    public GroupsResult getResult() {
        return this.result;
    }
    
    public void setResult(final GroupsResult result) {
        this.result = result;
    }
    
    public String toString() {
        return "Groups [result=" + this.result + "]";
    }
}
