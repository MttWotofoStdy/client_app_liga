package com.matveyperestoronin.client_app_liga_cifrovoy_economici.service;


import com.matveyperestoronin.client_app_liga_cifrovoy_economici.dto.ClientRequest;
import com.matveyperestoronin.client_app_liga_cifrovoy_economici.dto.ClientResponse;
import com.matveyperestoronin.client_app_liga_cifrovoy_economici.dto.UpdateClientRequest;
import com.matveyperestoronin.client_app_liga_cifrovoy_economici.mapper.ClientMapper;
import com.matveyperestoronin.client_app_liga_cifrovoy_economici.model.Client;
import com.matveyperestoronin.client_app_liga_cifrovoy_economici.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Transactional
    public ClientResponse createClient(ClientRequest request) {

        Client client = clientMapper.toNewClient(request);
        clientRepository.save(client);
        return clientMapper.responseClient(client);
    }

    @Transactional(readOnly = true)
    public List<ClientResponse> getClients() {
        return clientRepository.findAll().stream().map(clientMapper::responseClient).toList();
    }

    @Transactional(readOnly = true)
    public ClientResponse getClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " нет такого клиента"));
        return clientMapper.responseClient(client);
    }

    @Transactional
    public ClientResponse updateClient(Long id, UpdateClientRequest request) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " нет такого клиента"));
        if (request.name() != null && !request.name().isBlank()) {
            client.setName(request.name());
        }
        if (request.gender() != null && !request.gender().isBlank()) {
            String gender = request.gender().trim().toUpperCase();
            if ("M".equals(gender) || "F".equals(gender)) {
                client.setGender(gender);
            } else {
                throw new IllegalArgumentException("Пол M или F");
            }
        }
        if (request.status() != null && !request.status().isBlank()) {
                String status = request.status().trim().toUpperCase();
            if ("ACTIVE".equals(status) || "INACTIVE".equals(status)) {
                client.setStatus(status);
            } else {
                throw new IllegalArgumentException("Статус ACTIVE/INACTIVE");
            }
        }
        clientRepository.save(client);
        return clientMapper.responseClient(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new EntityNotFoundException(id + " не существует");
        } else {
            clientRepository.deleteById(id);
        }
    }
}
