package xyz.stxkfzx.manager.task.util;

import javafx.concurrent.Task;
import xyz.stxkfzx.manager.common.utils.GetWeek;
import xyz.stxkfzx.manager.task.pojo.TTask;
import xyz.stxkfzx.manager.task.pojo.vo.TaskVo;

import java.util.ArrayList;
import java.util.List;

public class TaskVoConver {

    public static TTask vo2po(TaskVo taskVo){
        TTask task = new TTask();
        task.setTaskId(taskVo.getTaskId());
        task.setCreateUserId(taskVo.getCreateUserId());
        task.setContent(taskVo.getContent());
        task.setCloseTime(GetWeek.timeStrConverTimestamp(taskVo.getCloseTime()));
        task.setRemindTime(GetWeek.timeStrConverTimestamp(taskVo.getRemindTime()));
        return task;
    }

    public static TaskVo po2vo(TTask task){
        TaskVo taskVo = new TaskVo();
        taskVo.setTaskId(task.getTaskId());
        taskVo.setContent(task.getContent());
        taskVo.setCreateUserId(task.getCreateUserId());

        String closeTimeStr = task.getCloseTime().toString();
        closeTimeStr = closeTimeStr.substring(0, closeTimeStr.lastIndexOf('.'));
        taskVo.setCloseTime(closeTimeStr);

        String remidTimeStr = task.getRemindTime().toString();
        remidTimeStr = remidTimeStr.substring(0, remidTimeStr.lastIndexOf('.'));
        taskVo.setRemindTime(remidTimeStr);

        return taskVo;
    }

    public static List<TaskVo> poList2voList(List<TTask> taskList){
        List<TaskVo> taskVos = new ArrayList<>();
        for(TTask task : taskList){
            taskVos.add(po2vo(task));
        }
        return taskVos;
    }
}
