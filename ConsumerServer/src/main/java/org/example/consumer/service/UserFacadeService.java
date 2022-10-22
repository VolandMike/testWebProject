package org.example.consumer.service;

import lombok.RequiredArgsConstructor;
import org.example.consumer.domain.UserDomain;
import org.example.consumer.dto.UserDTO;
import org.example.consumer.mapper.Mapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacadeService {
    private final Mapper mapper;
    private final UserService userService;

    public UserDomain saveUser(UserDTO user) {
        UserDomain userToSave = mapper.mapDtoToDomainUser(user);
        return userService.saveUser(userToSave);
    }
}
