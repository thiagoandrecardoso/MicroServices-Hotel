package com.example.hotel.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RoomByClientSaveRequest {
    private String cpf;
    private int number;
}
