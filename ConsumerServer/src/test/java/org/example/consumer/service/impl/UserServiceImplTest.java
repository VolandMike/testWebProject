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

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserRepository repository;
    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Test
    void testSaveUser() {
        UserDomain userDomain = getUserDomain();
        Mockito.when(repository.save(userDomain)).thenReturn(userDomain);
        UserDomain result = userServiceImpl.saveUser(userDomain);
        Assertions.assertEquals(userDomain, result);
    }


    @Test
    void testGetUserById() {
        UserDomain userDomain = getUserDomain();
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(userDomain));
        Optional<UserDomain> result = userServiceImpl.getUserById(1L);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(userDomain, result.get());
    }
    @Test
    void testGetUserByUserName() {
        UserDomain userDomain = getUserDomain();
        when(repository.getUserDomainByUsername(anyString())).thenReturn(Optional.of(userDomain));

        Optional<UserDomain> result = userServiceImpl.getUserByUserName("userName");
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(userDomain, result.get());
    }

    private UserDomain getUserDomain() {
        return new UserDomain(1L, "username", "firstname", "lastname", "password");
    }
}
