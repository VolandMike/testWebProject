package com.example.producerclient.exception;

public class MessageSenderException extends RuntimeException {
    public MessageSenderException(Exception e) {
        super(e);
    }
}
