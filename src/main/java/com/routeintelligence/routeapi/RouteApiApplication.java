package com.routeintelligence.routeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Route Intelligence API application.
 * <p>
 * This class bootstraps the Spring Boot framework and initializes
 * the embedded web server (Tomcat by default).
 *
 * @SpringBootApplication includes:
 * - @Configuration
 * - @EnableAutoConfiguration
 * - @ComponentScan
 */
@SpringBootApplication
public class RouteApiApplication {

    public static void main(String[] args) {
        // Launch the Spring Boot application
        SpringApplication.run(RouteApiApplication.class, args);
    }
}
