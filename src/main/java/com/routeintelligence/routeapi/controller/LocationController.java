package com.routeintelligence.routeapi.controller;

import com.routeintelligence.routeapi.model.Location;
import com.routeintelligence.routeapi.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for handling location-related HTTP requests.
 */
@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    /**
     * Constructor injection.
     */
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    /**
     * Create a new location inside a route.
     * <p>
     * Example:
     * POST /locations?routeId=1
     */
    @PostMapping
    public Location createLocation(@RequestParam Long routeId, @RequestBody Location location) {
        return locationService.createLocation(routeId, location);
    }

    /**
     * Get all locations of a route.
     * <p>
     * Example:
     * GET /locations/route/1
     */
    @GetMapping("/route/{routeId}")
    public List<Location> getLocationsByRoute(@PathVariable Long routeId) {
        return locationService.getLocationsByRoute(routeId);
    }
}
