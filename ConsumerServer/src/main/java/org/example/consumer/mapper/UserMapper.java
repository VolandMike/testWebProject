package org.example.consumer.mapper;

import org.example.consumer.domain.UserDomain;
import org.example.consumer.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "firstname", source = "firstname")
    @Mapping(target = "lastname", source = "lastname")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "username", source = "username")
    UserDomain mapDtoToDomainUser(UserDTO user);
}
