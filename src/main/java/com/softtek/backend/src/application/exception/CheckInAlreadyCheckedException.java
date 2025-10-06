package com.softtek.backend.src.application.exception;

public class CheckInAlreadyCheckedException extends RuntimeException {
    public CheckInAlreadyCheckedException() {
        super("User has already checked in today");
    }

    public CheckInAlreadyCheckedException(String message) {
        super(message);
    }

    public CheckInAlreadyCheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
