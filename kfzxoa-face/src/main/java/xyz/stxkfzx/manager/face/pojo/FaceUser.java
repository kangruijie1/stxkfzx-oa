package xyz.stxkfzx.manager.face.pojo;

public class FaceUser extends FaceBasic
{
    private FaceUserResult result;
    
    public FaceUser() {
    }
    
    public FaceUser(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached) {
        super(error_code, error_msg, log_id, timestamp, cached);
    }
    
    public FaceUser(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached, final FaceUserResult result) {
        super(error_code, error_msg, log_id, timestamp, cached);
        this.result = result;
    }
    
    public FaceUserResult getResult() {
        return this.result;
    }
    
    public void setResult(final FaceUserResult result) {
        this.result = result;
    }
    
    public String toString() {
        return "FaceUser [result=" + this.result + "]";
    }
}
