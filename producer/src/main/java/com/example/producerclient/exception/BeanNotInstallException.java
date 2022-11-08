package com.example.producerclient.exception;

public class BeanNotInstallException extends RuntimeException {
    public BeanNotInstallException(Exception e) {
        super(e);
    }
}
