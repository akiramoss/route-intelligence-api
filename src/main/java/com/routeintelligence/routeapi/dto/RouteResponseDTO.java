package com.routeintelligence.routeapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DTO returned to the client when sending route data.
 */
@Getter
@Setter
public class RouteResponseDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
}
