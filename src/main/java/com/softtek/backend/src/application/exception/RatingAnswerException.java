package com.softtek.backend.src.application.exception;

import org.springframework.http.HttpStatus;

public class RatingAnswerException extends RuntimeException {
    private final HttpStatus status;

    public RatingAnswerException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
