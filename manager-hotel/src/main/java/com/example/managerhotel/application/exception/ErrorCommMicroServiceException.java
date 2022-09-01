package com.example.managerhotel.application.exception;

import lombok.Getter;

public class ErrorCommMicroServiceException extends Exception {
    @Getter
    private final Integer status;

    public ErrorCommMicroServiceException(String msg, Integer status) {
        super(msg);
        this.status = status;
    }
}
