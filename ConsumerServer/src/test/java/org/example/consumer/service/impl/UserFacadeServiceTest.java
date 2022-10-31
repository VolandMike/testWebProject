package org.example.consumer.service.impl;

import org.example.consumer.domain.UserDomain;
import org.example.consumer.dto.UserDTO;
import org.example.consumer.mapper.UserMapper;
import org.example.consumer.service.UserService;
import org.example.consumer.service.impl.UserFacadeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserFacadeServiceTest {
    @Mock
    UserService userService;
    @InjectMocks
    UserFacadeService userFacadeService;

    @Test
    void testSaveUser() {
        when(userService.saveUser(any())).thenReturn(new UserDomain(1L, "username", "firstname", "lastname", "password"));

        UserDomain result = userFacadeService.saveUser(new UserDTO("username", "firstname", "lastname", "password"));
        Assertions.assertEquals(new UserDomain(1L, "username", "firstname", "lastname", "password"), result);
    }

    @Test
    void testSaveUserIfExist() {
        when(userService.getUserByUserName(any())).thenReturn(Optional.of(new UserDomain(1L, "username", "firstname", "lastname", "password")));

        UserDomain result = userFacadeService.saveUser(new UserDTO("username", "firstname", "lastname", "password"));
        Assertions.assertEquals(new UserDomain(1L, "username", "firstname", "lastname", "password"), result);
    }

    @Test
    void testGetUserById() {
        UserDomain expectedUser = new UserDomain();
        when(userService.getUserById(anyLong())).thenReturn(Optional.of(expectedUser));

        Optional<UserDomain> actualUser = userFacadeService.getUserById(1L);
        Assertions.assertTrue(actualUser.isPresent());
        Assertions.assertEquals(expectedUser, actualUser.get());
    }
}