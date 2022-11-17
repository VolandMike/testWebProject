package com.example.producerclient.exception;

public class UrlCreateException extends RuntimeException {
    public UrlCreateException(Exception exception) {
        super(exception);
    }
}
