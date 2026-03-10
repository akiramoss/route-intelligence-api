package com.routeintelligence.routeapi.repository;

import com.routeintelligence.routeapi.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Location entity.
 */
public interface LocationRepository extends JpaRepository<Location, Long> {

}
