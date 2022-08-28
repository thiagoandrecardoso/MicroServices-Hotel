package com.example.hotel.dto;

import com.example.hotel.entity.RoomClient;
import com.example.hotel.service.RoomService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RoomByClientSaveRequest {

    private final RoomService roomService;

    private String cpf;
    private int number;

    public RoomClient toModel() {
        return new RoomClient(cpf, roomService.getRoomByNumber(number));
    }
}
