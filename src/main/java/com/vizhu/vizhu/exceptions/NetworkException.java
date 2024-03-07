package com.vizhu.vizhu.exceptions;

/**
 * Для указания на проблемы с сетевым подключением, например,
 * при неудачных попытках взаимодействия с внешними сервисами через сеть.
 */
public class NetworkException extends RuntimeException {
    public NetworkException(String message) {
        super(message);
    }

    public NetworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
