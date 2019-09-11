package xyz.stxkfzx.manager.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.stxkfzx.manager.common.myException.OAException;
import xyz.stxkfzx.manager.task.mapper.TaskExecuteMapper;
import xyz.stxkfzx.manager.task.mapper.TaskMapper;
import xyz.stxkfzx.manager.task.pojo.TTask;
import xyz.stxkfzx.manager.task.pojo.TTaskExecute;
import xyz.stxkfzx.manager.task.pojo.vo.TaskVo;
import xyz.stxkfzx.manager.task.service.TaskService;
import xyz.stxkfzx.manager.task.util.TaskVoConver;

import java.util.ArrayList;
import java.util.List;

import static xyz.stxkfzx.manager.task.util.TaskVoConver.poList2voList;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    TaskExecuteMapper taskExecuteMapper;

    @Override
    public List<TaskVo> getTaskList(TTask task) {

        List<TTask> tTasks = taskMapper.selTTask(task);
        return poList2voList(tTasks);
    }

    @Override
    public TaskVo updateTask(TaskVo taskVo) {
        TTask task = TaskVoConver.vo2po(taskVo);
        Integer count = taskMapper.updateTTask(task);
        if(count == 1){
            TTask temp = new TTask();
            temp.setTaskId(task.getTaskId());
            List<TTask> tTasks = taskMapper.selTTask(temp);
            TTask resTask = tTasks.get(0);
            TaskVo resVo = TaskVoConver.po2vo(resTask);
            return resVo;
        }
        throw new OAException("更新任务失败!");
    }

    @Override
    public TaskVo addTask(TaskVo taskVo) {
        TTask task = TaskVoConver.vo2po(taskVo);
        Integer count = taskMapper.insertTTask(task);
        if(count == 1){
            TaskVo resVo = TaskVoConver.po2vo(task);
            return resVo;
        }
        throw new OAException("新增任务失败！");
    }

    @Override
    public void delTask(Integer taskId) {
        Integer count = taskMapper.deleteTTask(taskId);
        if(count != 1){
            new OAException("删除任务失败！");
        }
    }

    @Override
    public List<TTaskExecute> getExecuteList(TTaskExecute taskExecute) {
        List<TTaskExecute> tTaskExecutes = taskExecuteMapper.selTaskExecute(taskExecute);
        return tTaskExecutes;
    }

    @Override
    public List<TTaskExecute> addExecute(Integer taskId, String executeUserStr) {
        List<TTaskExecute> resList = new ArrayList<>();

        String[] split = executeUserStr.split(",");
        for(String userIdStr : split){
            Integer userId = Integer.valueOf(userIdStr);
            TTaskExecute execute = new TTaskExecute(taskId, userId);
            resList.add(execute);
        }
        Integer count = taskExecuteMapper.insertTTaskExecute(resList);
        if(count >= 1){
            return resList;
        }else{
            throw new OAException("新增执行人失败！");
        }
    }

    @Override
    public void delExecute(TTaskExecute taskExecute) {
        Integer count = taskExecuteMapper.delTTaskExecute(taskExecute);
        if(count != 1){
            new OAException("删除执行人失败！");
        }
    }
}
