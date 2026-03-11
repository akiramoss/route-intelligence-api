package com.routeintelligence.routeapi.controller;

import com.routeintelligence.routeapi.model.User;
import com.routeintelligence.routeapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for user-related endpoints.
 */
@RestController // (maneja requests HTTP)
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor injection of UserService.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create a new user.
     * <p>
     * POST /users
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Retrieve all users.
     * <p>
     * GET /users
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
