package xyz.stxkfzx.manager.face.pojo;

public class Groups
{
    private GroupsResult result;
    
    public Groups() {
    }
    
    public Groups(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached) {
    }
    
    public Groups(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached, final GroupsResult result) {
        this.result = result;
    }
    
    public GroupsResult getResult() {
        return this.result;
    }
    
    public void setResult(final GroupsResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "result=" + result +
                '}';
    }
}
