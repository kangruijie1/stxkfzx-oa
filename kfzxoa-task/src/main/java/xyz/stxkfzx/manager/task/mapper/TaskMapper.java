package xyz.stxkfzx.manager.task.mapper;

import xyz.stxkfzx.manager.task.pojo.TTask;

import java.util.List;

public interface TaskMapper {
    Integer insertTTask(TTask task);

    List<TTask> selTTask(TTask task);

    Integer updateTTask(TTask task);

    Integer deleteTTask(Integer taskId);
}
