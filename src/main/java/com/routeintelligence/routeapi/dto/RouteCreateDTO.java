package com.routeintelligence.routeapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO used when creating a new route.
 */
@Getter
@Setter
public class RouteCreateDTO {

    @NotBlank(message = "Route name is required")
    private String name;

    private String description;
}
