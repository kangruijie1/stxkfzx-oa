package xyz.stxkfzx.manager.face.pojo;

public class FaceBasic
{
    private String error_code;
    private String error_msg;
    private String log_id;
    private String timestamp;
    private String cached;
    
    public String getError_code() {
        return this.error_code;
    }
    
    public void setError_code(final String error_code) {
        this.error_code = error_code;
    }
    
    public String getError_msg() {
        return this.error_msg;
    }
    
    public void setError_msg(final String error_msg) {
        this.error_msg = error_msg;
    }
    
    public String getLog_id() {
        return this.log_id;
    }
    
    public void setLog_id(final String log_id) {
        this.log_id = log_id;
    }
    
    public String getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getCached() {
        return this.cached;
    }
    
    public void setCached(final String cached) {
        this.cached = cached;
    }
    
    public FaceBasic(final String error_code, final String error_msg, final String log_id, final String timestamp, final String cached) {
        this.error_code = error_code;
        this.error_msg = error_msg;
        this.log_id = log_id;
        this.timestamp = timestamp;
        this.cached = cached;
    }
    
    public FaceBasic() {
    }
    
    public String toString() {
        return "FaceBasic [error_code=" + this.error_code + ", error_msg=" + this.error_msg + ", log_id=" + this.log_id + ", timestamp=" + this.timestamp + ", cached=" + this.cached + "]";
    }
}
