package com.example.managerhotel.infra.clients;

import com.example.managerhotel.domain.model.RoomClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "hotel", path = "rooms")
public interface RoomResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<RoomClient>> getRoomByClient(@RequestParam("cpf") String cpf);

}
