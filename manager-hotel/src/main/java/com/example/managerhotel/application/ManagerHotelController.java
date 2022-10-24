package com.example.managerhotel.application;

import com.example.managerhotel.application.exception.DataClientNotFoundException;
import com.example.managerhotel.application.exception.ErrorCommMicroServiceException;
import com.example.managerhotel.domain.model.ClientInfo;
import com.example.managerhotel.domain.model.DataRequestRoom;
import com.example.managerhotel.domain.model.ProtocolRequestRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("manager-hotel")
@RequiredArgsConstructor
public class ManagerHotelController {

    private final ManagerHotelService managerHotelService;

    @GetMapping
    public String status() {
        return "Ok";
    }

    @GetMapping(value = "client-info", params = "cpf")
    public ResponseEntity getClientInfoByCpf(@RequestParam("cpf") String cpf) {
        ClientInfo clientInfo = null;
        try {
            clientInfo = managerHotelService.getClientInfoByCpf(cpf);
            return ResponseEntity.ok(clientInfo);
        } catch (DataClientNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErrorCommMicroServiceException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }


    @PostMapping(value = "request-room")
    public ResponseEntity requestRoom(@RequestBody DataRequestRoom dataRequestRoom) {
        try {
            ProtocolRequestRoom protocol = managerHotelService.getProtocolRequestRoom(dataRequestRoom);
            return ResponseEntity.ok(protocol);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
