package com.solovyeva.TaskManager.entity;

import com.solovyeva.TaskManager.model.Task;
import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTask(int id);
    void saveTask(Task task);
    void deleteTask(int id);
}
