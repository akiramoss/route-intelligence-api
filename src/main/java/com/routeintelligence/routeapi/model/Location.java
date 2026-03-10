package com.routeintelligence.routeapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a location within a route.
 *
 * A location corresponds to a specific geographic point
 * belonging to a route.
 */
@Entity
@Table(name = "locations")
@Getter
@Setter
public class Location {

    /**
     * Primary key of the location.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the location.
     * Example: "Plaza Mayor"
     */
    private String name;

    /**
     * Latitude coordinate of the location.
     */
    private Double latitude;

    /**
     * Longitude coordinate of the location.
     */
    private Double longitude;

    /**
     * Position of the location within the route.
     * Used to maintain order of stops.
     */
    private Integer orderIndex;

    /**
     * Relationship with Route.
     *
     * Many locations belong to one route.
     */
    @ManyToOne // Muchas locations --> una route
    @JoinColumn(name = "route_id")
    private Route route;

}
