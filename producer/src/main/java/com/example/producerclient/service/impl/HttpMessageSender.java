package com.example.producerclient.service.impl;

import com.example.producerclient.exception.HttpSendException;
import com.example.producerclient.service.MessageSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class HttpMessageSender implements MessageSender<HttpRequest> {

    @Override
    public void sendMessage(HttpRequest request) {

        String body = "Empty";
        try {
            final HttpResponse<String> send = HttpClient.newBuilder().build().send(
                    request, HttpResponse.BodyHandlers.ofString()
            );
            body = send.body();
        } catch (IOException | InterruptedException e) {
            log.error("Http response exception", e);
        }

        log.info("I'm getting message body {}", body);
    }
}
