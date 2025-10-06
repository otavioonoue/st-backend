package com.softtek.backend.src.infrastructure.exception;

public class DuplicatedKeyException extends RuntimeException {
    public DuplicatedKeyException(String message) {
        super(message);
    }
    
    public DuplicatedKeyException(String message, Throwable cause) {
        super(message, cause);
    }
	
}