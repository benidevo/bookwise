package com.benidevo.bookwise.common.exception;

import java.util.List;

public class ErrorResponse {
    private String message;
    private List<ErrorDetail> error;

    public ErrorResponse() {
    }

    public ErrorResponse(List<ErrorDetail> error, String message) {
        this.error = error;
        this.message = message;
    }

    public List<ErrorDetail> getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public void setError(List<ErrorDetail> error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
