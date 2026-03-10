package com.routeintelligence.routeapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Entity representing a route created by a user.
 * <p>
 * A route is a collection of locations that represent
 * a path or itinerary created by the user.
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
     * Example: "Madrid Tapas Walk"
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
     *
     * Many routes can belong to one user.
     */
    @ManyToOne // Muchas rutas --> un usuario
    @JoinColumn(name = "user_id") // Crea la columna "user_id" en la tabla routes
    private User user;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<Location> locations;
}
