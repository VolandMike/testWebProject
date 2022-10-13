package com.example.producerclient.service;

import com.example.producerclient.utils.RequestType;

import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public interface HttpRequestTypeBuilder {
    HttpRequest buildRequest(String message, RequestType requestType) throws URISyntaxException;
}
