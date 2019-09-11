package xyz.stxkfzx.manager.task.pojo.vo;

import java.sql.Timestamp;

public class TaskVo {
    private Integer taskId;
    private String content;
    private Integer createUserId;
    private String closeTime;
    private String remindTime;

    public TaskVo() {
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(String remindTime) {
        this.remindTime = remindTime;
    }

    @Override
    public String toString() {
        return "TaskVo{" +
                "taskId=" + taskId +
                ", content='" + content + '\'' +
                ", createUserId=" + createUserId +
                ", closeTime='" + closeTime + '\'' +
                ", remindTime='" + remindTime + '\'' +
                '}';
    }
}
