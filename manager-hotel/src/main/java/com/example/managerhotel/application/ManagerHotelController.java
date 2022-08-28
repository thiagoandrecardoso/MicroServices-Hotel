package com.example.managerhotel.application;

import com.example.managerhotel.application.exception.DataClientNotFoundException;
import com.example.managerhotel.application.exception.ErrorCommMicroServiceException;
import com.example.managerhotel.domain.model.ClientInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
