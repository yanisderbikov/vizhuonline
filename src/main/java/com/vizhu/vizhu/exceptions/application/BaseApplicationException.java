package com.vizhu.vizhu.exceptions.application;

public abstract class BaseApplicationException extends RuntimeException {
    public BaseApplicationException(String message) {
        super(message);
    }

    public BaseApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
