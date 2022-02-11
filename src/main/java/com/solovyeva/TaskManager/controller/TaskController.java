package com.solovyeva.TaskManager.controller;

import antlr.collections.List;
import com.solovyeva.TaskManager.dao.TaskDAO;
import com.solovyeva.TaskManager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class TaskController {

    private TaskDAO taskDAO;

    @Autowired
    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GetMapping("/tasks")
    public ArrayList<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id) {
        //        if (task == null) {
//            throw new RuntimeException("There is no task with Id = " + id);
//        }
        return taskDAO.getTask(id);
    }

    @PostMapping("/tasks")
    public Task addNewTask(@RequestBody Task task) {
        task.setId(0);
        task.setLastUpdate(new Date(System.currentTimeMillis()));
        taskDAO.saveTask(task);
        return task;

    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task task) {
        task.setLastUpdate(new Date(System.currentTimeMillis()));
        taskDAO.saveTask(task);
        return task;
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable int id) {
        try {
            taskDAO.deleteTask(id);
            return "Task " + id + " was deleted";
        } catch (Exception e) {
            return "Task " + id + " not found";
        }
    }

}
