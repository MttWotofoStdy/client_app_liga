package com.matveyperestoronin.client_app_liga_cifrovoy_economici.mapper;

import com.matveyperestoronin.client_app_liga_cifrovoy_economici.dto.ClientRequest;
import com.matveyperestoronin.client_app_liga_cifrovoy_economici.dto.ClientResponse;
import com.matveyperestoronin.client_app_liga_cifrovoy_economici.model.Client;
import org.springframework.stereotype.Component;


@Component
public class ClientMapper {

    public Client toNewClient(ClientRequest request) {
        Client cl = new Client();
        cl.setName(request.name());
        if (request.gender() != null && !request.gender().isBlank()) {
            cl.setGender(request.gender().toUpperCase());
        }
        return cl;
    }

public ClientResponse responseClient(Client client){
        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getGender(),
                client.getStatus(),
                client.getCreateDate(),
                client.getModifyDate());
}
}
