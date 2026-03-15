package com.routeintelligence.routeapi.controller;

import com.routeintelligence.routeapi.dto.UserCreateDTO;
import com.routeintelligence.routeapi.dto.UserResponseDTO;
import com.routeintelligence.routeapi.service.UserService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

/**
 * REST controller for user-related endpoints.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create user endpoint
     */
    @PostMapping
    // Spring valida automáticamente
    public UserResponseDTO createUser(@Valid @RequestBody UserCreateDTO dto) {
        return userService.createUser(dto);
    }

    /**
     * Get all users
     */
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }
}
