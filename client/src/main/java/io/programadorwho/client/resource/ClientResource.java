package io.programadorwho.client.resource;

import io.programadorwho.client.entity.dto.ClientSaveRequest;
import io.programadorwho.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
@Slf4j
public class ClientResource {
    private final ClientService clientService;

    @GetMapping
    public String status(){
        log.info("Getting microservice status from clients");
        return "OK";
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dataClient(@RequestParam("cpf") String cpf){
        var client = clientService.getByCpf(cpf);
        if (client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClientSaveRequest request){
        var client = request.toModel();
        clientService.save(client);

        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();

        return ResponseEntity.created(headerLocation).build();

    }
}
