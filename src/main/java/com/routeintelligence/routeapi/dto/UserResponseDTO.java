package com.routeintelligence.routeapi.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO returned to the client when sending user data.
 */
@Getter
@Setter
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
}
