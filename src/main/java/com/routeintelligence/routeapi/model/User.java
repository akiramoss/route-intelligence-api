package com.routeintelligence.routeapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    /**
     * Primary key of the user.
     *
     * GenerationType.IDENTITY means the database automatically
     * generates the ID (auto-increment).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Username chosen by the user.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * Email address of the user.
     */
    @Column(nullable = false, unique = true)
    private String email;

}
