package com.pimblott.samples.spring.boot.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Gordon on 12/05/2015.
 */
@SpringBootApplication
public class ExampleServiceApplication {

    public static void main( String[] args) {
        SpringApplication.run(ExampleService.class, args);
    }
}
