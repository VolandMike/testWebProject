package org.example.consumer.service;

import org.example.consumer.domain.UserDomain;
import org.example.consumer.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

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
}