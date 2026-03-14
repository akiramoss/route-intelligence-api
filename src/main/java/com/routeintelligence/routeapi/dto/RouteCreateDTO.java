package com.routeintelligence.routeapi.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO used when creating a new route.
 */
@Getter
@Setter
public class RouteCreateDTO {
    private String name;
    private String description;
}
