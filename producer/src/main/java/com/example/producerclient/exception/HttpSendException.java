package com.example.producerclient.exception;

public class HttpSendException extends RuntimeException{
    public HttpSendException(Exception e) {
        super(e);
    }
}
