package xyz.stxkfzx.manager.face.pojo;

public class FaceUserResultUserList extends FaceBasic
{
    private FaceUserResultUserListFinal result;
    
    public FaceUserResultUserList() {
    }
    
    public FaceUserResultUserList(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached) {
        super(error_code, error_msg, log_id, timestamp, cached);
    }
    
    public FaceUserResultUserList(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached, final FaceUserResultUserListFinal result) {
        super(error_code, error_msg, log_id, timestamp, cached);
        this.result = result;
    }
    
    public FaceUserResultUserListFinal getResult() {
        return this.result;
    }
    
    public void setResult(final FaceUserResultUserListFinal result) {
        this.result = result;
    }
    
    public String toString() {
        return "FaceUserResultUserList [result=" + this.result + "]";
    }
}
