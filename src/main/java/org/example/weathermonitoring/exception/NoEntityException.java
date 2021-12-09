package org.example.weathermonitoring.exception;

public class NoEntityException extends RuntimeException {
    public NoEntityException(Long message) {
        super(String.valueOf(message));
    }
}