package com.solovyeva.TaskManager.controller;

import com.solovyeva.TaskManager.dao.TaskDAO;
import com.solovyeva.TaskManager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskController {

    private TaskDAO taskDAO;

    @Autowired
    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id) {
        //        if (task == null) {
//            throw new RuntimeException("There is no task with Id = " + id);
//        }
        return taskDAO.getTask(id);
    }
    @PostMapping("/tasks")
    public Task addNewTask(@RequestBody Task task){
        taskDAO.saveTask(task);
        return task;

    }
    @PutMapping("/tasks/{id}")
    public void updateTask(@RequestBody Task task){
        taskDAO.saveTask(task);
    }

}
