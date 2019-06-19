package xyz.stxkfzx.manager.face.pojo;

public class Group
{
    private GroupResult result;
    
    public Group() {
    }
    
    public Group(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached) {
    }
    
    public Group(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached, final GroupResult result) {
        this.result = result;
    }
    
    public GroupResult getResult() {
        return this.result;
    }
    
    public void setResult(final GroupResult result) {
        this.result = result;
    }
    
}
