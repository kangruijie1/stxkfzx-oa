package xyz.stxkfzx.manager.task.pojo;

import java.sql.Timestamp;

public class TTask {
    private Integer taskId;
    private String content;
    private Integer createUserId;
    private Timestamp closeTime;
    private Timestamp remindTime;

    public TTask() {
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

    public Timestamp getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Timestamp closeTime) {
        this.closeTime = closeTime;
    }

    public Timestamp getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Timestamp remindTime) {
        this.remindTime = remindTime;
    }

    @Override
    public String toString() {
        return "TTask{" +
                "taskId=" + taskId +
                ", content='" + content + '\'' +
                ", createUserId=" + createUserId +
                ", closeTime=" + closeTime +
                ", remindTime=" + remindTime +
                '}';
    }
}
