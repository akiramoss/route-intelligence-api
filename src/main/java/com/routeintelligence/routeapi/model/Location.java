package com.routeintelligence.routeapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a geographic location within a route.
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
     */
    private String name;

    /**
     * Latitude coordinate.
     */
    private Double latitude;

    /**
     * Longitude coordinate.
     */
    private Double longitude;

    /**
     * Order of the location within the route.
     */
    private Integer orderIndex;

    /**
     * Many locations belong to one route.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    @JsonBackReference
    private Route route;

    /**
     * Default constructor required by JPA.
     */
    public Location() {}
}
