package com.oobss.controller;

import com.oobss.common.util.Result;
import com.oobss.entity.Task;
import com.oobss.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * Created by clarkzhao on 2017/12/30.
 *
 * @author clarkzhao
 * @date 2017/12/30
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/today")
    public Result getTodayTask() {
        Result result = taskService.getTodayTasks();
        return result;
    }

    @GetMapping("/test/init")
    public Result initTestData() throws ParseException {
        Result result = taskService.initTestData();
        return result;
    }

    @GetMapping("/main")
    public Result taskHomeInit() {
        return taskService.taskHomeInit();
    }

    @PostMapping
    public Result addTask(@RequestBody Task taskDTO) {
        return taskService.addTask(taskDTO);
    }

    @PatchMapping
    public Result fixTask(@RequestBody Task taskDTO){
        return taskService.fixTask(taskDTO);
    }

    @PatchMapping("/back")
    public Result openTask(@RequestBody Task taskDTO){
        return taskService.openTask(taskDTO);
    }

    @DeleteMapping
    public Result deleteTask(@RequestParam Long id){
        return taskService.deleteTask(id);
    }
}
