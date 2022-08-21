package com.example.hotel.service;

import com.example.hotel.entity.RoomClient;
import com.example.hotel.repository.RoomClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomClientService {

    private final RoomClientRepository roomClientRepository;

    public List<RoomClient> listRoomByClient(String cpf) {
        return roomClientRepository.findByCpf(cpf);
    }
}
