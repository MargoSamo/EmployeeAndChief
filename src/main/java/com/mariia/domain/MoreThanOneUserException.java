package com.mariia.domain;

public class MoreThanOneUserException extends RuntimeException {
    public MoreThanOneUserException(String message) {
        super(message);
    }
}
