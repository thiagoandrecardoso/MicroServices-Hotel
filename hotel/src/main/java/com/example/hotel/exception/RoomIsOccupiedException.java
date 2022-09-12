package com.example.hotel.exception;

public class RoomIsOccupiedException extends Exception{
    public RoomIsOccupiedException() {
        super("The room is occupied.");
    }
}
