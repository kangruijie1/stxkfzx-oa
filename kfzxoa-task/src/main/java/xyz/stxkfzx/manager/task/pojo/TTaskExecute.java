package xyz.stxkfzx.manager.task.pojo;

public class TTaskExecute {
    private Integer taskExecuteId;
    private Integer taskId;
    private Integer executeUserId;

    @Override
    public String toString() {
        return "TTaskExecute{" +
                "taskExecuteId=" + taskExecuteId +
                ", taskId=" + taskId +
                ", executeUserId=" + executeUserId +
                '}';
    }

    public TTaskExecute() {
    }

    public TTaskExecute(Integer taskId, Integer executeUserId) {
        this.taskId = taskId;
        this.executeUserId = executeUserId;
    }

    public Integer getTaskExecuteId() {
        return taskExecuteId;
    }

    public void setTaskExecuteId(Integer taskExecuteId) {
        this.taskExecuteId = taskExecuteId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getExecuteUserId() {
        return executeUserId;
    }

    public void setExecuteUserId(Integer executeUserId) {
        this.executeUserId = executeUserId;
    }
}
