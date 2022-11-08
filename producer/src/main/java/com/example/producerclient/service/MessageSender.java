package com.example.producerclient.service;

import com.example.producerclient.exception.MessageSenderException;

import java.net.http.HttpRequest;

public interface MessageSender {
    void sendMessage(HttpRequest request) throws MessageSenderException;
}
