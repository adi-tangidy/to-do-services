package com.vee.todoservice.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
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

    private static final Logger logger = Logger.getLogger(TaskController.class.getName());
    
    @Autowired
    private TaskService taskService;
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String loadMain() {
        return "main";
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView addTask(@RequestParam("task")String task, HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("main");
        taskService.addTask(new Task(task));
        try {
          //FIXME: redirection is not supported in HTTPS domain
            response.sendRedirect(request.getContextPath());
            logger.info(String.format("Redirected to %s.", request.getContextPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mv;
    }
    
    @RequestMapping(value="/check/{id}", method=RequestMethod.POST)
    public ModelAndView checkTask(@PathVariable("id") String taskId, HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("main");
        
        Task currTask = taskService.findByID(Long.parseLong(taskId));
        taskService.toggleTaskCheck(currTask);
        try {
            //FIXME: redirection is not supported in HTTPS domain
            response.sendRedirect(request.getContextPath());
            logger.info(String.format("Redirected to %s.", request.getContextPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return mv;
    }
    
    @ModelAttribute
    public List<Task> taskList(){
        return taskService.findAll();
    }
}
