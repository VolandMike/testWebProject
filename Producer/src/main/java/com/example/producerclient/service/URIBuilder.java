package com.example.producerclient.service;

import com.example.producerclient.config.ServiceConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class URIBuilder {
    private final ServiceConfig serviceConfig;

    public URI build() throws URISyntaxException {
        return new URI(serviceConfig.getRequestUrl());
    }
}
