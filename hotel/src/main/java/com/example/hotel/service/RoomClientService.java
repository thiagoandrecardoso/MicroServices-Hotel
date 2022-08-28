package com.example.hotel.service;

import com.example.hotel.entity.RoomClient;
import com.example.hotel.repository.RoomClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomClientService {

    private final RoomClientRepository roomClientRepository;

    @Transactional
    public RoomClient save(RoomClient roomClient){
        return roomClientRepository.save(roomClient);
    }

    public List<RoomClient> listRoomByCpf(String cpf) {
        return roomClientRepository.findByCpf(cpf);
    }
}
