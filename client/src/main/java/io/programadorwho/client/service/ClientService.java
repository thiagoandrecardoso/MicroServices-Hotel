package io.programadorwho.client.service;

import io.programadorwho.client.entity.Client;
import io.programadorwho.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    @Transactional
    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Optional<Client> getByCpf(String cpf){
        return clientRepository.findByCpf(cpf);
    }

}
