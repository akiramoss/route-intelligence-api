package com.routeintelligence.routeapi.service;

import com.routeintelligence.routeapi.repository.LocationRepository;
import org.springframework.stereotype.Service;

/**
 * Service layer responsible for location-related business logic.
 */
@Service
public class LocationService {

    private final LocationRepository locationRepository;

    /**
     * Constructor injection of LocationRepository.
     */
    public LocationService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }
}
