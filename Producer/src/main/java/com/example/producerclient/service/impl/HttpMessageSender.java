package com.example.producerclient.service.impl;

import com.example.producerclient.service.MessageSender;
import com.example.producerclient.utils.RequestType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class HttpMessageSender implements MessageSender {

    @Override
    public void sendMessage(String message, RequestType get) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/greeting?name=Mike"))
                .headers("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> send = HttpClient.newBuilder().build().send(
                request, HttpResponse.BodyHandlers.ofString()
        );

        log.info("I'm getting message body {}", send.body());
    }
}
