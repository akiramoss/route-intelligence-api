package com.routeintelligence.routeapi.controller;

import com.routeintelligence.routeapi.model.Route;
import com.routeintelligence.routeapi.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for handling route-related HTTP requests.
 */
@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    /**
     * Constructor injection of RouteService.
     */
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    /**
     * Create a new route for a specific user.
     * Example:
     * POST /routes?userId=1
     */
    @PostMapping
    public Route createRoute(@RequestParam Long userId, @RequestBody Route route) {
        return routeService.createRoute(userId, route);
    }

    /**
     * Retrieve all routes.
     * Example:
     * GET /routes
     */
    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }
}
