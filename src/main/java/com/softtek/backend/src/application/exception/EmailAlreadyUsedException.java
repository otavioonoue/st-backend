package com.softtek.backend.src.application.exception;

public class EmailAlreadyUsedException extends EmailException {

    public EmailAlreadyUsedException() {
        super("This email address is already taken");
    }

    public EmailAlreadyUsedException(String message) {
        super(message);
    }

    public EmailAlreadyUsedException(String message, Throwable cause) {
        super(message, cause);
    }

}
