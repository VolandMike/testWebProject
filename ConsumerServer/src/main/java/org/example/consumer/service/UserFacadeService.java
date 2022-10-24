package org.example.consumer.service;

import lombok.RequiredArgsConstructor;
import org.example.consumer.domain.UserDomain;
import org.example.consumer.dto.UserDTO;
import org.example.consumer.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacadeService {
    private final UserService userService;

    public UserDomain saveUser(UserDTO user) {
        UserDomain userToSave = UserMapper.MAPPER.mapDtoToDomainUser(user);
        return userService.saveUser(userToSave);
    }
}
