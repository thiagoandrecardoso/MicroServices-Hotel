package com.example.hotel.repository;

import com.example.hotel.entity.RoomClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomClientRepository extends JpaRepository<RoomClient, Long> {
    List<RoomClient> findByCpf(String cpf);
}
