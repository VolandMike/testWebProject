package org.example.consumer.mapper;

import org.example.consumer.domain.UserDomain;
import org.example.consumer.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class UserMapperTest {
    UserMapper mapper = UserMapper.MAPPER;

    @Test
    void mapDtoToDomainUser() {
        UserDTO userDto = createUserDto();
        UserDomain userDomain = mapper.mapDtoToDomainUser(userDto);
        Assertions.assertAll(
                () -> Assertions.assertEquals(userDto.getFirstname(), userDomain.getFirstname()),
                () -> Assertions.assertEquals(userDto.getLastname(), userDomain.getLastname()),
                () -> Assertions.assertEquals(userDto.getUsername(), userDomain.getUsername()),
                () -> Assertions.assertEquals(userDto.getPassword(), userDomain.getPassword())
        );
    }

    private UserDTO createUserDto() {
        return new UserDTO(UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString());
    }
}