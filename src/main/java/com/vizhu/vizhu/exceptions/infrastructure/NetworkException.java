package com.vizhu.vizhu.exceptions.infrastructure;

/**
 * Для указания на проблемы с сетевым подключением, например,
 * при неудачных попытках взаимодействия с внешними сервисами через сеть.
 */
public class NetworkException extends BaseInfrastructureException {
    public NetworkException(String message) {
        super(message);
    }
    public NetworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
