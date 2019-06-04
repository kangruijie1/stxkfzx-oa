package xyz.stxkfzx.manager.face.pojo;

public class Group extends FaceBasic
{
    private GroupResult result;
    
    public Group() {
    }
    
    public Group(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached) {
        super(error_code, error_msg, log_id, timestamp, cached);
    }
    
    public Group(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached, final GroupResult result) {
        super(error_code, error_msg, log_id, timestamp, cached);
        this.result = result;
    }
    
    public GroupResult getResult() {
        return this.result;
    }
    
    public void setResult(final GroupResult result) {
        this.result = result;
    }
    
    public String toString() {
        return "Group [result=" + this.result + "]";
    }
}
