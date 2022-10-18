package com.example.producerclient.service;

import java.net.http.HttpRequest;

public interface RequestBuilder {
    HttpRequest buildRequest(final String url);
}
