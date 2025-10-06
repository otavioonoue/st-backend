package com.softtek.backend.src.application.exception;

public class EmailDoesntExistsException extends EmailException {

    public EmailDoesntExistsException() {
        super("Email not found");
    }

    public EmailDoesntExistsException(String message) {
        super(message);
    }

    public EmailDoesntExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
