package com.routeintelligence.routeapi;

import com.routeintelligence.routeapi.dto.UserCreateDTO;
import com.routeintelligence.routeapi.dto.UserResponseDTO;
import com.routeintelligence.routeapi.mapper.UserMapper;
import com.routeintelligence.routeapi.model.User;
import com.routeintelligence.routeapi.repository.UserRepository;
import com.routeintelligence.routeapi.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void shouldCreateUser() {
        UserRepository repository = mock(UserRepository.class);
        UserMapper mapper = mock(UserMapper.class);

        UserService service = new UserService(repository, mapper);

        UserCreateDTO dto = new UserCreateDTO();
        dto.setUsername("test");
        dto.setEmail("test@email.com");

        User user = new User("test", "test@email.com");

        User savedUser = new User("test", "test@email.com");
        savedUser.setId(1L);

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setUsername("test");
        responseDTO.setEmail("test@email.com");

        when(mapper.toEntity(dto)).thenReturn(user);
        when(repository.save(user)).thenReturn(savedUser);
        when(mapper.toDTO(savedUser)).thenReturn(responseDTO);

        UserResponseDTO result = service.createUser(dto);

        assertEquals("test", result.getUsername());
        verify(repository).save(user);
    }
}
