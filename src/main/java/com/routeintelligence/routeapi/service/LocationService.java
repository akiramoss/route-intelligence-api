package com.routeintelligence.routeapi.service;

import com.routeintelligence.routeapi.model.Location;
import com.routeintelligence.routeapi.model.Route;
import com.routeintelligence.routeapi.repository.LocationRepository;
import com.routeintelligence.routeapi.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer responsible for location-related business logic.
 */
@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final RouteRepository routeRepository;

    /**
     * Constructor injection of LocationRepository.
     */
    public LocationService(LocationRepository locationRepository, RouteRepository routeRepository) {
        this.locationRepository = locationRepository;
        this.routeRepository = routeRepository;
    }

    /**
     * Create a new location inside a route.
     */
    public Location createLocation(Long routId, Location location) {

        Route route = routeRepository.findById(routId).orElseThrow(() -> new RuntimeException("Route not found"));
        location.setRoute(route);
        return locationRepository.save(location);
    }

    /**
     * Retrieve all locations for a specific route.
     */
    public List<Location> getLocationsByRoute(Long routeId) {
        Route route = routeRepository.findById(routeId).orElseThrow(() -> new RuntimeException("Route not found"));
        return route.getLocations();
    }
}
