package com.example.managerhotel.infra.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.managerhotel.domain.model.DataClient;

@FeignClient(value = "client", path = "/clients")
public interface HostResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<DataClient> dataClient(@RequestParam("cpf") String cpf);
}
