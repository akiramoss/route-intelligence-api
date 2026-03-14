package com.routeintelligence.routeapi.service;

import com.routeintelligence.routeapi.dto.RouteCreateDTO;
import com.routeintelligence.routeapi.dto.RouteResponseDTO;
import com.routeintelligence.routeapi.mapper.RouteMapper;
import com.routeintelligence.routeapi.model.Route;
import com.routeintelligence.routeapi.model.User;
import com.routeintelligence.routeapi.repository.RouteRepository;
import com.routeintelligence.routeapi.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.routeintelligence.routeapi.exception.ResourceNotFoundException;

/**
 * Service layer responsible for route-related business logic.
 */
@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    private final RouteMapper routeMapper;

    public RouteService(RouteRepository routeRepository, UserRepository userRepository, RouteMapper routeMapper) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
        this.routeMapper = routeMapper;
    }

    /**
     * Create a new route for a user.
     */
    public RouteResponseDTO createRoute(Long userId, RouteCreateDTO dto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Route route = routeMapper.toEntity(dto);
        route.setUser(user);

        Route savedRoute = routeRepository.save(route);

        return routeMapper.toDTO(savedRoute);
    }

    /**
     * Retrieve all routes.
     */
    public Page<RouteResponseDTO> getRoutes(Pageable pageable) {
        return routeRepository.findAll(pageable)
                .map(routeMapper::toDTO);
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
