package com.routeintelligence.routeapi.mapper;

import com.routeintelligence.routeapi.dto.RouteCreateDTO;
import com.routeintelligence.routeapi.dto.RouteResponseDTO;
import com.routeintelligence.routeapi.model.Route;
import org.mapstruct.Mapper;

/**
 * Mapper responsible for converting
 * Route entities to DTOs and vice versa.
 */
@Mapper(componentModel = "spring")
public interface RouteMapper {

    /**
     * Convert RouteCreateDTO → Route entity
     */
    Route toEntity(RouteCreateDTO dto);

    /**
     * Convert Route entity → RouteResponseDTO
     */
    RouteResponseDTO toDTO(Route route);
}
