package com.vizhu.vizhu.exceptions;

/**
 * Для обозначения ошибок, связанных с базой данных,
 * таких как невозможность подключения, ошибки в запросах и т.д.
 */
public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
