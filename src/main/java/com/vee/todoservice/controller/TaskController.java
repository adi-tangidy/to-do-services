package com.vee.todoservice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vee.todoservice.model.Task;
import com.vee.todoservice.services.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String loadMain() {
        return "main";
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView addTask(@RequestParam("task")String task, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("main");
        taskService.addTask(new Task(task));
        try {
            response.sendRedirect("/to-do-service/");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mv;
    }
    
    @RequestMapping(value="/check/{id}", method=RequestMethod.POST)
    public ModelAndView checkTask(@PathVariable("id") String taskId, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("main");
        
        Task currTask = taskService.findByID(Long.parseLong(taskId));
        taskService.toggleTaskCheck(currTask);
        try {
            response.sendRedirect("/to-do-service/");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return mv;
    }
    
    @ModelAttribute
    public List<Task> taskList(){
        return taskService.findAll();
    }
}
