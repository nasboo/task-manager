package com.solovyeva.TaskManager.controller;

import com.solovyeva.TaskManager.model.Task;
import com.solovyeva.TaskManager.entity.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id) {

        return taskService.getTask(id);
    }

    @PostMapping("/tasks")
    public Task addNewTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return task;
    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return task;
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }

}
