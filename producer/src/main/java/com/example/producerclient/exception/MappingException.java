package com.example.producerclient.exception;

public class MappingException extends RuntimeException {
    public MappingException(Exception e) {
        super(e);
    }
}
