package com.routeintelligence.routeapi.mapper;

import com.routeintelligence.routeapi.dto.UserCreateDTO;
import com.routeintelligence.routeapi.dto.UserResponseDTO;
import com.routeintelligence.routeapi.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserCreateDTO dto);

    UserResponseDTO toDTO(User user);
}
