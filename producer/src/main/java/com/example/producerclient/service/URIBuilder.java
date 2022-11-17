package com.example.producerclient.service;

import com.example.producerclient.config.ServiceConfig;
import com.example.producerclient.exception.URLNotFoundException;
import com.example.producerclient.exception.UrlCreateException;
import com.example.producerclient.utils.RequestType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class URIBuilder {
    private final ServiceConfig serviceConfig;

    public URI build(RequestType requestType) {
        if (serviceConfig.getServiceUrls().containsKey(requestType)) {
            try {
                return new URI(serviceConfig.getServiceUrls().get(requestType).stream().findFirst().orElseThrow());
            } catch (URISyntaxException e) {
                throw new UrlCreateException(e);
            }
        }
        throw new URLNotFoundException("Can't find urls for request type " + requestType);
    }
}
