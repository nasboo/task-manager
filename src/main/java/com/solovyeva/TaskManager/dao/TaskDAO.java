package com.solovyeva.TaskManager.dao;

import com.solovyeva.TaskManager.model.Task;

public interface TaskDAO {
    void saveTask(Task task);

    Task getTask(int id);

    void deleteTask(int id);
}
