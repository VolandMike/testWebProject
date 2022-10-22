package org.example.consumer.mapper;

import org.example.consumer.domain.UserDomain;
import org.example.consumer.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public UserDomain mapDtoToDomainUser(UserDTO user) {
        return UserDomain.builder()
                .firstname(user.getFirstname())
                .password(user.getPassword())
                .username(user.getUsername())
                .lastname(user.getLastname())
                .build();
    }
}
