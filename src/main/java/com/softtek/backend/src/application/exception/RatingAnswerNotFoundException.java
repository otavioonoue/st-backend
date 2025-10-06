package com.softtek.backend.src.application.exception;

import org.springframework.http.HttpStatus;

public class RatingAnswerNotFoundException extends RatingAnswerException {
    public RatingAnswerNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Ratting Answer not found");
    }
}
