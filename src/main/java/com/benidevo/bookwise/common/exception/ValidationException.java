package com.benidevo.bookwise.common.exception;

import java.util.List;

public class ValidationException extends RuntimeException {
    private final List<ErrorDetail> errors;

    public ValidationException(List<ErrorDetail> errors) {
        this.errors = errors;
    }

    public List<ErrorDetail> getErrors() {
        return errors;
    }
}
