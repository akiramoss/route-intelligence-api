package com.routeintelligence.routeapi.repository;

import com.routeintelligence.routeapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for User entity.
 * <p>
 * JpaRepository provides CRUD operations automatically.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    // Entity: User, Primary Key: Long

}
