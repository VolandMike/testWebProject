package org.example.consumer.service;

import org.example.consumer.domain.UserDomain;
import org.example.consumer.dto.UserDTO;

import java.util.Optional;

public interface UserFacade {
    UserDomain saveUser(UserDTO userDTO);

    Optional<UserDomain> getUserById(Long id);
}
