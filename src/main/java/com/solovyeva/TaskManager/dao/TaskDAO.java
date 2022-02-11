package com.solovyeva.TaskManager.dao;

import com.solovyeva.TaskManager.model.Task;

import java.util.ArrayList;
import java.util.List;

public interface TaskDAO {
    ArrayList<Task> getAllTasks();

    void saveTask(Task task);

    Task getTask(int id);

    void deleteTask(int id) throws Exception;
}
