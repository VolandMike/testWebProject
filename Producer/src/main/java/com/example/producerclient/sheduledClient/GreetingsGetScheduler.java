package com.example.producerclient.sheduledClient;

import com.example.producerclient.config.UserConfig;
import com.example.producerclient.service.MessageSender;
import com.example.producerclient.service.RequestBuilder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;

@Service
@Slf4j
@RequiredArgsConstructor
public class GreetingsGetScheduler {
    private final RequestBuilder requestBuilder;
    private final MessageSender messageSender;

    private final UserConfig userConfig;

    @SneakyThrows
    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    public void scheduleFixedRateWithInitialDelayTask() {
        URI sampleData = new URI("http://localhost:8080/users");
        userConfig.getUserListFromCsv().forEach(user -> {
                    HttpRequest request = requestBuilder.buildRequest(sampleData, user);
                    try {
                        messageSender.sendMessage(request);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}
