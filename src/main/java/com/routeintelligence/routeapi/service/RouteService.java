package com.routeintelligence.routeapi.service;

import com.routeintelligence.routeapi.model.Route;
import com.routeintelligence.routeapi.model.User;
import com.routeintelligence.routeapi.repository.RouteRepository;
import com.routeintelligence.routeapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer responsible for route-related business logic.
 */
@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final UserRepository userRepository;

    /**
     * Constructor injection of dependencies.
     */
    public RouteService(RouteRepository routeRepository, UserRepository userRepository) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
    }

    /**
     * Creates a new route for a given user.
     */
    public Route createRoute(Long userId, Route route) {

        // Retrieve the user from database
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Associate route with user
        route.setUser(user);

        // Save route
        return routeRepository.save(route);
    }

    /**
     * Retrieve all routes.
     */
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

}
