package com.vizhu.vizhu.exceptions.domain;

public abstract class BaseDomainException extends RuntimeException {
    public BaseDomainException(String message) {
        super(message);
    }

    public BaseDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}