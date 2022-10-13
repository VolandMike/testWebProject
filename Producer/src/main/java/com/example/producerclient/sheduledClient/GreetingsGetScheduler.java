package com.example.producerclient.sheduledClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class GreetingsGetScheduler {

    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    public void scheduleFixedRateWithInitialDelayTask() throws URISyntaxException, IOException, InterruptedException {

        byte[] sampleData = "http://localhost:8080/greeting?name=Mike".getBytes();
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
