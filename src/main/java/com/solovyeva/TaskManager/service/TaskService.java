package com.solovyeva.TaskManager.service;

import com.solovyeva.TaskManager.entity.Task;
import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTask(String id);
    void saveTask(Task task);
    void deleteTask(String id);
}
