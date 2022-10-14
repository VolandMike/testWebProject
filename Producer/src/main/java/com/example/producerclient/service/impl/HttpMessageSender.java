package com.example.producerclient.service.impl;

import com.example.producerclient.service.MessageSender;
import com.example.producerclient.utils.RequestType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class HttpMessageSender implements MessageSender {

    @Override
    public void sendMessage(String message, RequestType requestType) throws IOException, InterruptedException, URISyntaxException {

        var values = new HashMap<String, String>() {{
            put("name", "John Doe");
        }};

        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(values);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(message))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> send = HttpClient.newBuilder().build().send(
                request, HttpResponse.BodyHandlers.ofString()
        );

        log.info("I'm getting message body {}", send.body());
    }
}
