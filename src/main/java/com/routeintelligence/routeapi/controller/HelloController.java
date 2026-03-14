package com.routeintelligence.routeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HealthController
 * <p>
 * Simple controller used to verify that the API is running correctly.
 * <p>
 * This endpoint is typically used for:
 * - health checks
 * - monitoring
 * - debugging
 */
@RestController // Define que la clase responde a peticiones HTTP
public class HelloController {

    /**
     * Basic health check endpoint.
     * <p>
     * HTTP Method: GET
     * URL: /health
     *
     * @return status message confirming that the API is running
     */
    @GetMapping("/hello") // Define un endpoint
    public String hello() {
        return "Hello Route Intelligence API";
    }
}
