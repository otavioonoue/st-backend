package com.softtek.backend.src.application.exception;

import org.springframework.http.HttpStatus;

public class RatingAnswerAlreadyCreatedException extends RatingAnswerException {
    public RatingAnswerAlreadyCreatedException() {
        super(HttpStatus.CONFLICT, "You already have created this Ratting Answer");
    }
}
