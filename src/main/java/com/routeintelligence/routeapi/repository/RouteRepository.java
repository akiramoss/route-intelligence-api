package com.routeintelligence.routeapi.repository;

import com.routeintelligence.routeapi.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Route entity.
 */
public interface RouteRepository extends JpaRepository<Route, Long> {
}
