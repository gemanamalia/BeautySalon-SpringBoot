package com.unibuc.beautysalon.controller;
import com.unibuc.beautysalon.dto.SimpleClientDto;
import com.unibuc.beautysalon.entity.Client;
import com.unibuc.beautysalon.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clients")

public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<SimpleClientDto>> getAllClientsAsDto() {
        List<SimpleClientDto> clientsDto = clientService.getAllClientsAsDto();
        return new ResponseEntity<>(clientsDto, HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<SimpleClientDto> getSimpleClientDtoById(@PathVariable Long clientId) {
        SimpleClientDto simpleClientDto = clientService.getSimpleClientDtoById(clientId);
        if (simpleClientDto != null) {
            return ResponseEntity.ok(simpleClientDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Client> addSimpleClient(@RequestBody SimpleClientDto simpleClientDto) {
        Client client = new Client();
        client.setId(simpleClientDto.getId());
        client.setName(simpleClientDto.getName());

        Client savedClient = clientService.saveClient(client);

        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long clientId) {
        boolean deleted = clientService.deleteClient(clientId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
