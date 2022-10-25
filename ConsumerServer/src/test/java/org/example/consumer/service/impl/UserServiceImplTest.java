package org.example.consumer.service.impl;

import org.example.consumer.domain.UserDomain;
import org.example.consumer.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserRepository repository;
    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Test
    void testSaveUser() {
        UserDomain userDomain = new UserDomain(1L, "username", "firstname", "lastname", "password");
        Mockito.when(repository.save(userDomain)).thenReturn(userDomain);
        UserDomain result = userServiceImpl.saveUser(userDomain);
        Assertions.assertEquals(userDomain, result);
    }
}
