package xyz.stxkfzx.manager.auth.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 本类只用于封装与 Token 部分相关的实体，故只包含了四个基本属性
 *
 * @author VicterTian
 * @version V1.0
 * @date 2019/4/13
 */
@SuppressWarnings("all")
public class UserBase implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private Date createTime;
    private Integer managerType;
    private Short status;

    public UserBase(Integer userId, String username, Integer status) {
        this.userId = userId;
        this.username = username;
        this.status = status.shortValue();
    }

    public UserBase(Integer userId, String username, Short status) {
        this.userId = userId;
        this.username = username;
        this.status = status;
    }

    public UserBase(Integer userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public UserBase() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserBase{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", managerType=" + managerType +
                ", status=" + status +
                '}';
    }
}
