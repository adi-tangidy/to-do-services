package com.vee.todoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vee.todoservice.model.Task;
import com.vee.todoservice.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskControllerREST {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Task> taskList(){
        return taskService.findAll();
    }
    
    @RequestMapping("/list/{checked}")
    @ResponseBody
    public List<Task> taskListByFinishedStatus(@PathVariable("checked") boolean checked){
        return taskService.findByStatus(checked);
    }
    
}
