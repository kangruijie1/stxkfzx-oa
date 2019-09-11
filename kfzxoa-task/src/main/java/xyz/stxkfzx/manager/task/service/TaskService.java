package xyz.stxkfzx.manager.task.service;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.stxkfzx.manager.common.pojo.FaceResult;

import xyz.stxkfzx.manager.task.pojo.TTask;
import xyz.stxkfzx.manager.task.pojo.TTaskExecute;
import xyz.stxkfzx.manager.task.pojo.vo.TaskVo;
import xyz.stxkfzx.manager.user.pojo.TUser;

import java.util.List;

public interface TaskService {
    /**
     * 获取任务列表
     * @param task
     * @return
     */
    List<TaskVo> getTaskList(TTask task);

    /**
     * 修改任务内容
     * @param taskVo
     * @return
     */
    TaskVo updateTask(TaskVo taskVo);

    /**
     * 添加任务
     * @param taskVo
     * @return
     */
    TaskVo addTask(TaskVo taskVo);

    /**
     * 删除任务
     * @param taskId
     * @return
     */
    void delTask(Integer taskId);

    /**
     * 获取任务执行人列表
     * @param taskExecute
     * @return
     */
    List<TTaskExecute> getExecuteList(TTaskExecute taskExecute);

    /**
     * 添加执行人
     * @param taskId
     * @param executeUserStr
     * @return
     */
    List<TTaskExecute> addExecute(Integer taskId, String executeUserStr);

    /**
     * 删除执行人
     * @param taskExecute
     * @return
     */
    void delExecute(TTaskExecute taskExecute);
}
