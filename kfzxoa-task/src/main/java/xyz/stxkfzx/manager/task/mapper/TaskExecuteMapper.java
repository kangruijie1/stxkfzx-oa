package xyz.stxkfzx.manager.task.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.stxkfzx.manager.task.pojo.TTask;
import xyz.stxkfzx.manager.task.pojo.TTaskExecute;

import java.util.List;

public interface TaskExecuteMapper {
    Integer insertTTaskExecute(@Param("executes")List<TTaskExecute> executes);

    List<TTaskExecute> selTaskExecute(TTaskExecute taskExecute);

    Integer delTTaskExecute(TTaskExecute taskExecute);
}
