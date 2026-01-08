package com.vehicleSystem.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.vehicleSystem")
@PropertySource("classpath:application.properties")
public class ConfigClass {

}
