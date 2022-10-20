package com.example.producerclient.mapper;

import com.example.producerclient.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Mapper {
    public String mapDomainUserToDto(User user) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            log.error("Can't map object {} to json ", user);
            throw new RuntimeException(e);
        }
        return json;
    }
}
