package com.vee.todoservice.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vee.todoservice.AbstractTest;
import com.vee.todoservice.mock.DummyTaskService;
import com.vee.todoservice.model.Task;

public class TaskServiceTest extends AbstractTest{

    @Autowired
    private TaskService taskService;
    
    /**
     * Dummy initial data test to check on initial data load
     * 5 dummy data shall be populated upon load at the first time
     * to mimic initial database load
     */
    @Test
    public void initialDummyDataTest() {
        assertThat(taskService.findAll().size(), is(equalTo(5)));
        assertThat(taskService.findByID(1L), is(notNullValue()));
        assertThat(taskService.findByID(2L), is(notNullValue()));
        assertThat(taskService.findByID(3L), is(notNullValue()));
        assertThat(taskService.findByID(4L), is(notNullValue()));
        assertThat(taskService.findByID(5L), is(notNullValue()));
    }
    
    @Test
    public void addTask01() {
        Task addedTask = taskService.addTask(new Task("Test Dummy Task 01"));
        
        assertThat(taskService.findAll().size(), is(equalTo(6)));
        assertThat(addedTask.getId(), is(equalTo(6L)));
        assertThat(addedTask.getTaskName(), is(equalTo("Test Dummy Task 01")));
        assertThat(addedTask.isChecked(), is(equalTo(false)));
    }
    
    @Test
    public void addTask02() {
        Task newTask = new Task("Test Dummy Task 01");
        newTask.setChecked(true);
        Task addedTask = taskService.addTask(newTask);
        
        assertThat(taskService.findAll().size(), is(equalTo(6)));
        assertThat(addedTask.getId(), is(equalTo(6L)));
        assertThat(addedTask.getTaskName(), is(equalTo("Test Dummy Task 01")));
        assertThat(addedTask.isChecked(), is(equalTo(true)));
    }
    
    @Test
    public void checkTask01() {
        Task uncheckedTask = taskService.findByID(1L);
        assertThat(uncheckedTask.isChecked(), is(equalTo(false)));
        taskService.toggleTaskCheck(uncheckedTask);
        
        // after toggle check task
        Task checkedTask = taskService.findByID(1L);
        assertThat(checkedTask.isChecked(), is(equalTo(true)));
        taskService.toggleTaskCheck(checkedTask);
        
        // re-toggle task checked state
        Task finalTask = taskService.findByID(1L);
        assertThat(finalTask.isChecked(), is(equalTo(false)));
    }
    
    @Before
    public void init() {
        // ensure data reset for every test
        if(taskService instanceof DummyTaskService) {
            DummyTaskService dummyService = (DummyTaskService) taskService;
            dummyService.resetDummyData();
        }
    }
}
