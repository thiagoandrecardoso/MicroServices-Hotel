package com.example.hotel.service;

import com.example.hotel.entity.Room;
import com.example.hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    @Transactional
    public Room save(Room room){
        return roomRepository.save(room);
    }

    public Room getRoomByNumber(int number){
        return roomRepository.findByNumber(number);
    }

    public List<Room> getRoomsFree(){
        return roomRepository.findByIsOccupied(false);
    }
}
