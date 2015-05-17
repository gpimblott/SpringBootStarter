package com.pimblott.samples.spring.boot.service.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleService {

    @RequestMapping("/")
    String home() {
        return "Greetings from Spring Boot!";
    }

}