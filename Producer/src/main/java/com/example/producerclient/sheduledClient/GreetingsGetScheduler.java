package com.example.producerclient.sheduledClient;

import com.example.producerclient.service.MessageSender;
import com.example.producerclient.service.RequestBuilder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;

@Service
@Slf4j
@RequiredArgsConstructor
public class GreetingsGetScheduler {
    private final RequestBuilder requestBuilder;
    private final MessageSender messageSender;
    @SneakyThrows
    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    public void scheduleFixedRateWithInitialDelayTask() {
        String sampleData = "http://localhost:8080/users";
        HttpRequest request = requestBuilder.buildRequest(sampleData);
        messageSender.sendMessage(request);

    }
}
