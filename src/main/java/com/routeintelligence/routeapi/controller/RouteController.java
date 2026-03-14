package com.routeintelligence.routeapi.controller;

import com.routeintelligence.routeapi.dto.RouteCreateDTO;
import com.routeintelligence.routeapi.dto.RouteResponseDTO;
import com.routeintelligence.routeapi.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for route-related endpoints.
 */
@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    /**
     * Create route endpoint
     */
    @PostMapping
    public RouteResponseDTO createRoute(
            @RequestParam Long userId,
            @RequestBody RouteCreateDTO dto
    ) {
        return routeService.createRoute(userId, dto);
    }

    /**
     * Get all routes
     */
    @GetMapping
    public List<RouteResponseDTO> getAllRoutes() {
        return routeService.getAllRoutes();
    }
}
