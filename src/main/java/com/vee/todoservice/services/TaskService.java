package com.vee.todoservice.services;

import java.util.List;

import com.vee.todoservice.model.Task;

public interface TaskService {

    Task addTask(Task task);
    
    void removeTask(Task task);
    
    void toggleTaskCheck(Task task);
    
    List<Task> findAll();
    
    Task findByID(Long id);
}
