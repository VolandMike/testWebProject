package com.example.producerclient.service.impl;

import com.example.producerclient.service.RequestBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.HashMap;

@Service
@Slf4j
public class RequestPostBuilderImpl implements RequestBuilder {

    @Override
    public HttpRequest buildRequest(final String url) {
        var values = new HashMap<String, String>() {{
            put("name", "John Doe");
        }};

        try {
            var objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(values);
            return HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .headers("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
        } catch (URISyntaxException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
