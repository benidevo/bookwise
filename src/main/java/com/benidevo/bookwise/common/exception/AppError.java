package com.benidevo.bookwise.common.exception;

public class AppError extends RuntimeException {
    private final String message;

    public AppError(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
