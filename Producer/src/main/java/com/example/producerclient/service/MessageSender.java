package com.example.producerclient.service;

import com.example.producerclient.utils.RequestType;

public interface MessageSender {
    void sendMessage(String message, RequestType get) throws Exception;
}
