package org.example.weathermonitoring.exception;

public class NoEntityException extends RuntimeException {
    public NoEntityException(String message) {
        super(message);
    }
}