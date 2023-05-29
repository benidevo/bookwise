package com.benidevo.bookwise.common.exception;

public class RecordNotFoundException extends RuntimeException{
    private final String message;

    public RecordNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
