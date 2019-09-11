package xyz.stxkfzx.manager.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.stxkfzx.manager.common.utils.GetWeek;
import xyz.stxkfzx.manager.task.mapper.TaskExecuteMapper;
import xyz.stxkfzx.manager.task.mapper.TaskMapper;
import xyz.stxkfzx.manager.task.pojo.TTask;
import xyz.stxkfzx.manager.task.pojo.TTaskExecute;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@MapperScan({"xyz.stxkfzx.manager.task.mapper"})
@SpringBootTest
public class MapperTests {

    @Autowired
    TaskMapper mapper;

    @Autowired
    TaskExecuteMapper taskExecuteMapper;
    @Test
    public void contextLoads() {
        TTask task = new TTask();
        task.setContent("666");
        task.setCloseTime(GetWeek.getCurrentTime());
        task.setRemindTime(GetWeek.getCurrentTime());
        task.setCreateUserId(34);
        Integer taskId = mapper.insertTTask(task);

        TTaskExecute tTaskExecute = new TTaskExecute();
        tTaskExecute.setTaskId(task.getTaskId());
        tTaskExecute.setExecuteUserId(87);

        List<TTaskExecute> executes = new ArrayList<>();
        executes.add(tTaskExecute);
        Integer integer = taskExecuteMapper.insertTTaskExecute(executes);
        tTaskExecute.setExecuteUserId(46);
      //  Integer integer1 = taskExecuteMapper.insertTTaskExecute(tTaskExecute);

        List<TTask> tTasks = mapper.selTTask(new TTask());

        tTaskExecute.setTaskId(task.getTaskId());
        List<TTaskExecute> tTaskExecute1 = taskExecuteMapper.selTaskExecute(tTaskExecute);
        ;
    }

}
