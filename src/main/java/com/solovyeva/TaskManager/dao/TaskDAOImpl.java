package com.solovyeva.TaskManager.dao;

import com.solovyeva.TaskManager.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TaskDAOImpl implements TaskDAO{
    private static int TASK_COUNT;
    List<Task> taskList = new ArrayList<>();
    {
        taskList.add(new Task(1,"one","dsddsdsd",new Date()));
        taskList.add(new Task(2,"two","dsddsdsd",new Date()));
        taskList.add(new Task(3,"three","dsddsdsd",new Date()));
        taskList.add(new Task(4,"four","dsddsdsd",new Date()));
    }

    public TaskDAOImpl() {
    }

    public TaskDAOImpl(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public void saveTask(Task task) {
        saveOrUpdate(task);
    }

    @Override
    public Task getTask(int id) {
        return taskList.stream().filter(t -> t.getId() == id).findAny().orElse(null);
    }


    @Override
    public void deleteTask(int id) {
        taskList.removeIf(t -> t.getId() == id);
    }

    private void saveOrUpdate(Task task) {
        int id = task.getId();
        if (id == 0) {
            task.setId(++TASK_COUNT);
            taskList.add(task);
        } else {
            taskList.stream().filter(t -> t.getId() == id).forEach(t -> {
                t.setName(task.getName());
                t.setDescription(task.getDescription());
                t.setLastUpdate(new Date(System.currentTimeMillis()));
            });
        }
    }
}