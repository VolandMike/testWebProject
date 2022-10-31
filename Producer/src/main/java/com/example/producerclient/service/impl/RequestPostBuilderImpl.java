package com.example.producerclient.service.impl;

import com.example.producerclient.dto.User;
import com.example.producerclient.mapper.Mapper;
import com.example.producerclient.service.RequestBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;

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
