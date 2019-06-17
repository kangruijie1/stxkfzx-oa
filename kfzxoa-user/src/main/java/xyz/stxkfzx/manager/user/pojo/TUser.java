package xyz.stxkfzx.manager.user.pojo;

import java.io.Serializable;
import java.util.Date;

public class TUser implements Serializable {
    private Integer userId;
    private String departmentId;
    private String jobId;
    private String username;
    private String password;
    private String phoneNum;
    private Date createTime;
    private Date updateTime;
    private Integer managerType;
    private Short status;

    public TUser() {
    }

    public Integer getManagerType() {
        return managerType;
    }

    public void setManagerType(Integer managerType) {
        this.managerType = managerType;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public int getUserId() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "userId=" + userId +
                ", departmentId='" + departmentId + '\'' +
                ", jobId='" + jobId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", managerType=" + managerType +
                ", status=" + status +
                '}';
    }
}
