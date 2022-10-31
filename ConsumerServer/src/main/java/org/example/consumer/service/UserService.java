package org.example.consumer.service;

import org.example.consumer.domain.UserDomain;

import java.util.Optional;

public interface UserService {
    UserDomain saveUser(UserDomain user);

    Optional<UserDomain> getUserById(Long id);

    Optional<UserDomain> getUserByUserName(String userName);
}
