package com.solovyeva.TaskManager.dao;

import com.solovyeva.TaskManager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,String> {

}
