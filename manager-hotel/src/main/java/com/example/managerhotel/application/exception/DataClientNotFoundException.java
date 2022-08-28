package com.example.managerhotel.application.exception;

public class DataClientNotFoundException extends Exception {
    public DataClientNotFoundException() {
        super("Client data not found!");
    }
}
