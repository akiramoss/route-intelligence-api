package com.routeintelligence.routeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller used to verify that the API is running.
 */
@RestController
public class HealthController {

    /**
     * Simple health check endpoint.
     */
    @GetMapping("/health")
    public String health() {
        return "Route Intelligence API is running";
    }
}
