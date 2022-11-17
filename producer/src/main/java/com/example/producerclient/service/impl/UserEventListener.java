package com.example.producerclient.service.impl;

import com.example.producerclient.dto.User;
import com.example.producerclient.service.MessageSender;
import com.example.producerclient.service.ProducerEventListener;
import com.example.producerclient.service.RequestBuilder;
import com.example.producerclient.service.URIBuilder;
import com.example.producerclient.utils.RequestType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserEventListener implements ProducerEventListener<User> {
    private final RequestBuilder requestBuilder;
    private final MessageSender<HttpRequest> messageSender;
    private final URIBuilder uriBuilder;

    @EventListener
    public void onEvent(User user) {
        log.info("I was get message: {}", user);
        final URI sampleData = uriBuilder.build(RequestType.POST);
        final HttpRequest request = requestBuilder.buildRequest(sampleData, user);
        messageSender.sendMessage(request);
    }
}
