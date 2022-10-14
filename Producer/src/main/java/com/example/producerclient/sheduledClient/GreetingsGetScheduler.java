package com.example.producerclient.sheduledClient;

import com.example.producerclient.service.MessageSender;
import com.example.producerclient.utils.RequestType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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
@RequiredArgsConstructor
public class GreetingsGetScheduler {
    private final MessageSender messageSender;
    @SneakyThrows
    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    public void scheduleFixedRateWithInitialDelayTask() {
        String sampleData = "http://localhost:8080/users";
        messageSender.sendMessage(sampleData, RequestType.GET);
    }
}
