package io.programadorwho.client.entity.dto;

import io.programadorwho.client.entity.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientSaveRequest {
    private String name;
    private String cpf;

    public Client toModel(){
        return new Client(name, cpf);
    }
}
