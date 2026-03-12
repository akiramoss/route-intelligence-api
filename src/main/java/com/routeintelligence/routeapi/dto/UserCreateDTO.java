package com.routeintelligence.routeapi.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO used when creating a new user.
 * Represents the data sent by the client.
 */
@Getter
@Setter
public class UserCreateDTO {
    private String username;
    private String email;
}
