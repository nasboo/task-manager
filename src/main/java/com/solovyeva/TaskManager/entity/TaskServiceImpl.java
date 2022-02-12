package com.solovyeva.TaskManager.entity;

import com.solovyeva.TaskManager.dao.TaskRepository;
import com.solovyeva.TaskManager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(int id) {
        Optional<Task> optional = taskRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void saveTask(Task task) {
        task.setLastUpdate(new Date(System.currentTimeMillis()));
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
