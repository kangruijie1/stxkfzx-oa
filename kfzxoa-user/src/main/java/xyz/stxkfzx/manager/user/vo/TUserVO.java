package xyz.stxkfzx.manager.user.vo;

public class TUserVO {
    private Integer userId;
    private String departmentId;
    private String jobId;
    private String username;
    private String phoneNum;
    private short status;

    public TUserVO() {
    }

    @Override
    public String toString() {
        return "TUserVO{" +
                "userId=" + userId +
                ", departmentId='" + departmentId + '\'' +
                ", jobId='" + jobId + '\'' +
                ", username='" + username + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
