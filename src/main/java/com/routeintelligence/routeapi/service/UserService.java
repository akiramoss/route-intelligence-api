package com.routeintelligence.routeapi.service;

import com.routeintelligence.routeapi.model.User;
import com.routeintelligence.routeapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for User operations.
 * <p>
 * This class contains the business logic related to users.
 */
@Service // Indica que esta clase tiene lógica de negocio
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructor injection of UserRepository.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Save a new user in the database.
     */
    public User createUser(User user){
        return userRepository.save(user);
    }

    /**
     * Retrieve all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
