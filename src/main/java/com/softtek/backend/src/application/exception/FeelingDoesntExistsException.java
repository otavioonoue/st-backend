package com.softtek.backend.src.application.exception;

public class FeelingDoesntExistsException extends RuntimeException {
    public FeelingDoesntExistsException() {
        super("Feeling doesnt exists");
    }

    public FeelingDoesntExistsException(String message) {
        super(message);
    }

    public FeelingDoesntExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
