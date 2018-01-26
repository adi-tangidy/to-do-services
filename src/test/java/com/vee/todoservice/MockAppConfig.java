package com.vee.todoservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vee.todoservice.mock.DummyTaskService;
import com.vee.todoservice.services.TaskService;

@Configuration
public class MockAppConfig {

    @Bean
    public TaskService dummyTaskService() {
        return new DummyTaskService();
    }
    
}
