package org.example.consumer.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.consumer.domain.UserDomain;
import org.example.consumer.dto.UserDTO;
import org.example.consumer.mapper.UserMapper;
import org.example.consumer.service.UserFacade;
import org.example.consumer.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserFacadeService implements UserFacade {
    private final UserService userService;

    public UserDomain saveUser(UserDTO user) {
        UserDomain userToSave = UserMapper.MAPPER.mapDtoToDomainUser(user);
        return userService.getUserByUserName(userToSave.getUsername())
                .orElseGet(() -> userService.saveUser(userToSave));
    }

    public Optional<UserDomain> getUserById(Long id) {
        return userService.getUserById(id);
    }
}
