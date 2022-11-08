package com.example.producerclient.service.impl;

import com.example.producerclient.exception.MessageSenderException;
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
public class HttpMessageSender implements MessageSender {

    @Override
    public void sendMessage(HttpRequest request) {

        final HttpResponse<String> send;
        try {
            send = HttpClient.newBuilder().build().send(
                    request, HttpResponse.BodyHandlers.ofString()
            );
        } catch (IOException | InterruptedException e) {
            throw new MessageSenderException(e);
        }

        log.info("I'm getting message body {}", send.body());
    }
}
