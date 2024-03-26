package com.vizhu.vizhu.exceptions.infrastructure;

/**
 * Для обозначения ошибок, связанных с базой данных,
 * таких как невозможность подключения, ошибки в запросах и т.д.
 */
public class DatabaseException extends BaseInfrastructureException {
    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
