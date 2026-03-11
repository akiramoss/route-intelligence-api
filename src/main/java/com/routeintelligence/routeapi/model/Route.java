package com.routeintelligence.routeapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entity representing a route created by a user.
 * A route is composed of multiple locations that define an itinerary or path.
 */
@Entity
@Table(name = "routes")
@Getter
@Setter
public class Route {

    /**
     * Primary key of the route.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the route.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Optional description of the route.
     */
    private String description;

    /**
     * Timestamp when the route was created.
     */
    private LocalDateTime createdAt;

    /**
     * Relationship with User.
     * Many routes belong to one user.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    /**
     * Locations belonging to this route.
     */
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Location> locations;

    /**
     * Default constructor required by JPA.
     */
    public Route() {}

    /**
     * Automatically set creation timestamp.
     */
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
