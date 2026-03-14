package com.routeintelligence.routeapi.service;

import com.routeintelligence.routeapi.dto.UserCreateDTO;
import com.routeintelligence.routeapi.dto.UserResponseDTO;
import com.routeintelligence.routeapi.model.User;
import com.routeintelligence.routeapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer for User operations.
 */
@Service // Lógica de negocio
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
    public UserResponseDTO createUser(UserCreateDTO userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());

        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    /**
     * Retrieve all users.
     */
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Convert Entity → Response DTO
     */
    private UserResponseDTO mapToResponse(User user) {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());

        return dto;
    }
}
