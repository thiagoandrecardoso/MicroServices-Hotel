package com.example.hotel.dto;

import com.example.hotel.entity.Room;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomSaveRequest {
    private int number;
    private double price;
    private boolean isOccupied;

    public Room toModel(){
        return new Room(number, price, isOccupied);
    }
}
