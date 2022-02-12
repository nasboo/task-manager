package com.solovyeva.TaskManager.entity;

import com.solovyeva.TaskManager.dao.TaskRepository;
import com.solovyeva.TaskManager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        List<Task> allTasks = taskRepository.findAll();
        allTasks.sort((o1, o2) -> o2.getLastUpdate().compareTo(o1.getLastUpdate()));
        return allTasks;
    }

    @Override
    public Task getTask(String id) {
        Optional<Task> optional = taskRepository.findById(id);
        return optional.orElse(null);
    }


    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
