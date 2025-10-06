package com.softtek.backend.shared.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.softtek.backend.src.application.exception.CheckInAlreadyCheckedException;
import com.softtek.backend.src.application.exception.EmailException;
import com.softtek.backend.src.application.exception.FeelingDoesntExistsException;
import com.softtek.backend.src.application.exception.RatingAnswerException;
import com.softtek.backend.src.application.exception.RatingNotFoundException;
import com.softtek.backend.src.infrastructure.exception.DuplicatedKeyException;
import com.softtek.backend.src.infrastructure.exception.EmailSendException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
        MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
            .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }
    
    @ExceptionHandler(DuplicatedKeyException.class)
    public ResponseEntity<Map<String, String>> handleDuplicatedValidationExceptions(
        DuplicatedKeyException ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("DUPLICATED", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
    } 

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<Map<String, String>> handleEmailValidationExceptions(
        EmailException ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("EMAIL", ex.getMessage());

        return ResponseEntity.internalServerError().body(errors);
    }

    @ExceptionHandler(RatingNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRatingValidationExceptions(
        RatingNotFoundException ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("RATING", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    @ExceptionHandler(EmailSendException.class)
    public ResponseEntity<Map<String, String>> handleEmailSendExceptions(
        EmailSendException ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("EMAIL_SERVICE", ex.getMessage());

        return ResponseEntity.internalServerError().body(errors);
    }

    @ExceptionHandler(RatingAnswerException.class)
    public ResponseEntity<Map<String, String>> handleRatingAnswerExceptions(
        RatingAnswerException ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("RATING_ANSWER", ex.getMessage());

        return ResponseEntity.status(ex.getStatus()).body(errors);
    }

    @ExceptionHandler(CheckInAlreadyCheckedException.class)
    public ResponseEntity<Map<String, String>> handleCheckInAlreadyCheckedExceptions(
        CheckInAlreadyCheckedException ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("CHECKIN", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errors); 
    }

    @ExceptionHandler(FeelingDoesntExistsException.class)
    public ResponseEntity<Map<String, String>> handleFeelingDoesntExistsExceptions(
        FeelingDoesntExistsException ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("FEELING", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors); 
    }
}