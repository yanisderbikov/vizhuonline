package com.vizhu.vizhu.exceptions.domain;

public class UserNotFoundException extends BaseDomainException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
