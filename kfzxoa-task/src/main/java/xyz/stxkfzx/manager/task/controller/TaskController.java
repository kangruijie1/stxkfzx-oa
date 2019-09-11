package xyz.stxkfzx.manager.task.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.task.pojo.TTask;
import xyz.stxkfzx.manager.task.pojo.TTaskExecute;
import xyz.stxkfzx.manager.task.pojo.vo.TaskVo;
import xyz.stxkfzx.manager.task.service.TaskService;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @Reference
    UserService userService;

    /**
     * 查询任务列表
     *
     * @param userId
     * @return
     */
    @RequestMapping("student/task/sel/task/list")
    public FaceResult selTaskList(@RequestParam Integer userId) {
        TTask task = new TTask();
        task.setCreateUserId(userId);
        List<TaskVo> taskList = taskService.getTaskList(task);
        return new FaceResult().ok(taskList);
    }

    /**
     * 更新某个任务
     *
     * @param taskVo
     * @return
     */
    @RequestMapping("student/task/update/task")
    public FaceResult updateTask(@RequestBody TaskVo taskVo) {
        return new FaceResult().ok(taskService.updateTask(taskVo));
    }

    /**
     * 添加一个任务
     *
     * @param taskVo
     * @return
     */
    @RequestMapping("student/task/add/task")
    public FaceResult addTask(@RequestBody TaskVo taskVo) {
        return new FaceResult().ok(taskService.addTask(taskVo));
    }

    /**
     * 删除一个任务
     *
     * @param taskId
     * @return
     */
    @RequestMapping("student/task/del/task")
    public FaceResult delTask(Integer taskId) {
        //删除任务
        taskService.delTask(taskId);

        //删除任务的执行人
        TTaskExecute taskExecute = new TTaskExecute();
        taskExecute.setTaskId(taskId);
        taskService.delExecute(taskExecute);

        return new FaceResult().ok(null);
    }

    /**
     * 查询执行人列表
     *
     * @param taskExecute
     * @return
     */
    @RequestMapping("student/task/sel/execute/list")
    public FaceResult selTaskExecute(@RequestBody TTaskExecute taskExecute) {
        List<TUser> users = new ArrayList<>();
        List<TTaskExecute> executeList = taskService.getExecuteList(taskExecute);
        for (TTaskExecute execute : executeList) {
            TUser user = userService.getTUserByUserId(execute.getExecuteUserId());
            users.add(user);
        }
        return new FaceResult().ok(users);
    }

    /**
     * 添加执行人
     *
     * @param taskId
     * @return
     */
    @RequestMapping("student/task/add/execute")
    public FaceResult addTaskExecute(@RequestParam Integer taskId,
                                     @RequestParam String executeUserStr) {
        return new FaceResult().ok(taskService.addExecute(taskId, executeUserStr));
    }

    /**
     * 删除一个执行人
     *
     * @param taskExecute
     * @return
     */
    public FaceResult delTaskExecute(@RequestBody TTaskExecute taskExecute) {
        taskService.delExecute(taskExecute);
        return new FaceResult().ok(null);
    }
}
