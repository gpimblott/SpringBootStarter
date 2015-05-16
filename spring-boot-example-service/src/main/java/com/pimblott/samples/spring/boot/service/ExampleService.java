package com.pimblott.samples.spring.boot.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ExampleService {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

}