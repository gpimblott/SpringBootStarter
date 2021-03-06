package com.pimblott.samples.spring.boot.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Custom Health indicator
 */
@Component
public class CustomHealth implements HealthIndicator {


    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    /**
     * Return 0 = always healthy
     * @return 0
     */
    private int check() {
        return 0;
    }

}
