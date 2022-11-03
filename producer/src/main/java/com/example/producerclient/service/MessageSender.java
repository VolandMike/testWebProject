package com.example.producerclient.service;

import java.net.http.HttpRequest;

public interface MessageSender {
    void sendMessage(HttpRequest request) throws Exception;
}
