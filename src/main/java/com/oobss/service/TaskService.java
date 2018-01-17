package com.oobss.service;

import com.oobss.common.util.Result;
import com.oobss.entity.Task;
import com.oobss.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by clarkzhao on 2017/12/30.
 *
 * @author clarkzhao
 * @date 2017/12/30
 */
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    /**
     * 查询当日未完成任务
     * @return
     */
    public Result getTodayTasks() {
        Result result = new Result();
        Date time = new Date();
        result.setData(taskRepository.findAllByTimeAndFinished(time,false));
        return result;
    }

    /**
     * 新增待办任务
     * @param taskDTO
     * @return
     */
    public Result addTask(Task taskDTO){
        Result result = new Result();
        Task task = new Task();
        task.setName(taskDTO.getName());
        result.setData(taskRepository.save(task));
        return result;
    }

    public Result initTestData() throws ParseException {
        Result result = new Result();
        List<Task> tasks = new ArrayList<>(3);
        Task t1 = new Task();
        t1.setName("任务1");
        Task t2 = new Task();
        t2.setName("任务2");
        t2.setFinished(true);
        Task t3 = new Task();
        t3.setName("任务3");
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Task t4 = new Task();
        t4.setName("历史任务1");
        t4.setTime(sdf.parse("2017-12-25"));

        tasks.add(t4);

        Task t5 = new Task();
        t5.setName("历史任务2");
        t5.setTime(sdf.parse("2017-12-25"));
        t5.setFinished(true);

        tasks.add(t4);

        result.setData(taskRepository.save(tasks));
        return result;
    }

    /**
     * 同时查询今日待办、今日已办、往日遗留任务
     * @return
     */
    public Result taskHomeInit(){
        Result result = new Result();
        Map<String,List<Task>> taskListMap = new HashMap<>(3);
        Date time = new Date();
        taskListMap.put("currentTasks",taskRepository.findAllByTimeAndFinished(time,false));
        taskListMap.put("finishedTasks",taskRepository.findAllByTimeAndFinished(time,true));
        taskListMap.put("lastTasks",taskRepository.queryLastTask(time,false));
        result.setData(taskListMap);
        return result;
    }

    /**
     * 完成任务
     * @param taskDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Result fixTask(Task taskDTO){
        Result result = new Result();
        Long taskId = taskDTO.getId();
        result.setData(taskRepository.updateFinishById(taskId,true));
        return result;
    }

    /**
     * 重新打开已完成的任务
     * @param taskDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Result openTask(Task taskDTO){
        Result result = new Result();
        Long taskId = taskDTO.getId();
        result.setData(taskRepository.updateFinishById(taskId,false));
        return result;
    }

    /**
     * 删除任务
     * @param id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Result deleteTask(Long id){
        Result result = new Result();
        taskRepository.delete(id);
        return result;
    }
}
