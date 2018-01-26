package com.vee.todoservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.vee.todoservice.services"})
public class AppConfig {

}
