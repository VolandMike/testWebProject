package com.example.producerclient.service.impl;

import com.example.producerclient.config.UserConfig;
import com.example.producerclient.dto.User;
import com.example.producerclient.mapper.Mapper;
import com.example.producerclient.service.RequestBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RequestPostBuilderImpl implements RequestBuilder {
    private final Mapper mapper;

    @Override
    public HttpRequest buildRequest(final URI url, final User user) {

        String requestBody = mapper.mapDomainUserToDto(user);
        return HttpRequest.newBuilder()
                .uri(url)
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
    }
}
