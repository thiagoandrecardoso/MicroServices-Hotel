package io.programadorwho.client.service;

import io.programadorwho.client.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientService clientService;

    @Transactional
    public Client save(Client client){
        return clientService.save(client);
    }

    public Optional<Client> getByCpf(String cpf){
        return clientService.getByCpf(cpf);
    }

}
