package com.example.hotel.dto;

import com.example.hotel.entity.RoomClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomByClientResponse {
    private int number;
    private double price;

    public static RoomByClientResponse fromModel(RoomClient roomClient) {
        return new RoomByClientResponse(
                roomClient.getRoom().getNumber(),
                roomClient.getRoom().getPrice()
        );
    }
}
