package com.softtek.backend.src.application.exception;

public class RatingNotFoundException extends RuntimeException {
    public RatingNotFoundException() {
        super("Ratting not found");
    }

    public RatingNotFoundException(String message) {
        super(message);
    }

    public RatingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
