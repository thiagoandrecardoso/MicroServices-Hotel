package com.example.managerhotel.application.exception;

import lombok.Getter;

public class ErrorCommMicroServiceException extends Exception{
    @Getter
    private Integer status;

    public ErrorCommMicroServiceException(String msg, Integer status) {
        super(msg);
        this.status = status;
    }
}
