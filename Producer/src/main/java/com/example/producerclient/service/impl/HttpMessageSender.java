package com.example.producerclient.service.impl;

import com.example.producerclient.service.HttpRequestTypeBuilder;
import com.example.producerclient.service.MessageSender;
import com.example.producerclient.utils.RequestType;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class HttpMessageSender implements MessageSender {
    private final HttpRequestTypeBuilder requestTypeBuilder;

    @Override
    public void sendMessage(String message, RequestType requestType) throws IOException, InterruptedException, URISyntaxException {

        HttpRequest request = requestTypeBuilder.buildRequest(message, requestType);
        HttpResponse<String> send = HttpClient.newBuilder().build().send(
                request, HttpResponse.BodyHandlers.ofString()
        );

        log.info("I'm getting message body {}", send.body());
    }
}
