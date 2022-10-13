package com.example.producerclient.service.impl;

import com.example.producerclient.service.HttpRequestTypeBuilder;
import com.example.producerclient.utils.RequestType;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

@Service
public class HttpRequestTypeBuilderImpl implements HttpRequestTypeBuilder {

    @Override
    public HttpRequest buildRequest(String message, RequestType requestType) throws URISyntaxException {

        HttpRequest.Builder headers = HttpRequest.newBuilder()
                .uri(new URI(message))
                .headers("Content-Type", "application/json");
        if (requestType == RequestType.GET){
            headers.GET();
        }
        return headers
                .build();
    }
}
