package com.vizhu.vizhu.exceptions.infrastructure;

public abstract class BaseInfrastructureException extends RuntimeException {
    public BaseInfrastructureException(String message) {
        super(message);
    }
    public BaseInfrastructureException(String message, Throwable cause) {
        super(message, cause);
    }
}