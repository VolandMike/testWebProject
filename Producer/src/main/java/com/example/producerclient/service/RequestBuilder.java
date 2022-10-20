package com.example.producerclient.service;

import com.example.producerclient.dto.User;

import java.net.URI;
import java.net.http.HttpRequest;

public interface RequestBuilder {
    HttpRequest buildRequest(final URI url, final User user);
}
