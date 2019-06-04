package xyz.stxkfzx.manager.face.pojo;

public class FaceAddResult extends FaceBasic
{
    private Object result;
    
    public FaceAddResult() {
    }
    
    public FaceAddResult(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached) {
        super(error_code, error_msg, log_id, timestamp, cached);
    }
    
    public FaceAddResult(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached, final Object result) {
        super(error_code, error_msg, log_id, timestamp, cached);
        this.result = result;
    }
    
    public Object getResult() {
        return this.result;
    }
    
    public void setResult(final Object result) {
        this.result = result;
    }
    
    public String toString() {
        return "FaceAddResult [result=" + this.result + "]";
    }
}
