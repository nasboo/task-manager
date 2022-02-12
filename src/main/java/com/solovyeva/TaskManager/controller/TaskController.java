package com.solovyeva.TaskManager.controller;

import com.solovyeva.TaskManager.entity.TaskService;
import com.solovyeva.TaskManager.exception.NoSuchTaskException;
import com.solovyeva.TaskManager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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
    public Task getTask(@PathVariable String id) {
        Task task = taskService.getTask(id);
        if (task == null) {
            throw new NoSuchTaskException();
        }
        return task;
    }

    @PostMapping("/tasks")
    public Task addNewTask(@Valid @RequestBody Task task) {
        Task current;
        if ((task.getName() == null || task.getDescription() == null)
                & (current = taskService.getTask(task.getId())) != null) {
            return save(task, current);
        }
        return save(task, new Task(task.getId(), "", ""));
    }

    @PutMapping("/tasks")
    public Task updateTask(@Valid @RequestBody Task task) {
        Task current = taskService.getTask(task.getId());
        if (current == null) {
            throw new NoSuchTaskException();
        }
        return save(task, current);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }

    private Task save(Task source, Task dest) {
        String name = source.getName();
        String description = source.getDescription();
        if (name != null) dest.setName(name);
        if (description != null) dest.setDescription(description);
        dest.setLastUpdate(new Date(System.currentTimeMillis()));
        taskService.saveTask(dest);
        return dest;
    }

}
