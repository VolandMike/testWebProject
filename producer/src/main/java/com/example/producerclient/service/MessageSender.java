package com.example.producerclient.service;

public interface MessageSender<T> {
    void sendMessage(T request);
}
