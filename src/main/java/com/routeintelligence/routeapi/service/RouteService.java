package com.routeintelligence.routeapi.service;

import com.routeintelligence.routeapi.dto.RouteCreateDTO;
import com.routeintelligence.routeapi.dto.RouteResponseDTO;
import com.routeintelligence.routeapi.model.Route;
import com.routeintelligence.routeapi.model.User;
import com.routeintelligence.routeapi.repository.RouteRepository;
import com.routeintelligence.routeapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.routeintelligence.routeapi.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer responsible for route-related business logic.
 */
@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final UserRepository userRepository;

    public RouteService(RouteRepository routeRepository, UserRepository userRepository) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
    }

    /**
     * Create a new route for a user.
     */
    public RouteResponseDTO createRoute(Long userId, RouteCreateDTO dto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Route route = new Route();
        route.setName(dto.getName());
        route.setDescription(dto.getDescription());
        route.setUser(user);

        Route savedRoute = routeRepository.save(route);

        return mapToResponse(savedRoute);
    }

    /**
     * Retrieve all routes.
     */
    public List<RouteResponseDTO> getAllRoutes() {

        return routeRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Convert Entity → DTO
     */
    private RouteResponseDTO mapToResponse(Route route) {

        RouteResponseDTO dto = new RouteResponseDTO();

        dto.setId(route.getId());
        dto.setName(route.getName());
        dto.setDescription(route.getDescription());
        dto.setCreatedAt(route.getCreatedAt());

        return dto;
    }
}