package com.pimblott.samples.spring.boot.service.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple Hello REST service mapped to the root URL
 *
 * Any authenticated user can access this URL
 */
@RestController
public class HelloService {

    @RequestMapping("/")
    String sayHello() {
        return "Greetings from Spring Boot!";
    }

}