package com.routeintelligence.routeapi.repository;

import com.routeintelligence.routeapi.model.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Route entity.
 */
public interface RouteRepository extends JpaRepository<Route, Long> {

    // Query Method Parsing --> WHERE LOWER(name) LIKE LOWER('%value%')
    Page<Route> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Route> findByUserId(Long userId, Pageable pageable);

    Page<Route> findByNameContainingIgnoreCaseAndUserId(String name, Long userId, Pageable pageable);
}
