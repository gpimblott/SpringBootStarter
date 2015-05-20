package com.pimblott.samples.spring.boot.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Main Spring Boot class - Everything is auto configured
 */
@Configuration
@EnableAutoConfiguration(exclude = {JmxAutoConfiguration.class})
@ComponentScan
public class ExampleServiceApplication {

    public static void main( String[] args) {
        SpringApplication.run(ExampleServiceApplication.class, args);
    }
}
