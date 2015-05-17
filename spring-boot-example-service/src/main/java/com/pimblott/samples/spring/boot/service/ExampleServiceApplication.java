package com.pimblott.samples.spring.boot.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.EndpointMBeanExportAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Gordon on 12/05/2015.
 */
@Configuration
@EnableAutoConfiguration(exclude = {JmxAutoConfiguration.class, EndpointMBeanExportAutoConfiguration.class})
@ComponentScan
public class ExampleServiceApplication {

    public static void main( String[] args) {
        SpringApplication.run(ExampleServiceApplication.class, args);
    }
}
