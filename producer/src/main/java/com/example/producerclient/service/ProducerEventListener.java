package com.example.producerclient.service;

public interface ProducerEventListener<T> {
    void onEvent(T message);
}
