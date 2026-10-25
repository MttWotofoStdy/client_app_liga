package com.matveyperestoronin.client_app_liga_cifrovoy_economici.controller;


import com.matveyperestoronin.client_app_liga_cifrovoy_economici.dto.ClientRequest;
import com.matveyperestoronin.client_app_liga_cifrovoy_economici.dto.ClientResponse;
import com.matveyperestoronin.client_app_liga_cifrovoy_economici.dto.UpdateClientRequest;
import com.matveyperestoronin.client_app_liga_cifrovoy_economici.service.ClientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    final private ClientService clientService;


    @PostMapping
    public ResponseEntity<ClientResponse> postClient(@Valid @RequestBody ClientRequest request) {
        return ResponseEntity.ok(clientService.createClient(request));
    }

    @GetMapping()
    public ResponseEntity<List<ClientResponse>> getClients() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getCurClient(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(clientService.getClient(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable @Positive Long id, @RequestBody @Valid UpdateClientRequest request) {
        return ResponseEntity.ok(clientService.updateClient(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable @Positive  Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
