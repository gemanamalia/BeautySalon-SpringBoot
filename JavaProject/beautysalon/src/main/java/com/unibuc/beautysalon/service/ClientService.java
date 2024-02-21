package com.unibuc.beautysalon.service;

import com.unibuc.beautysalon.dto.SimpleClientDto;
import com.unibuc.beautysalon.entity.Client;
import com.unibuc.beautysalon.mapper.ClientMapper;
import com.unibuc.beautysalon.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public List<SimpleClientDto> getAllClientsAsDto() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::ClientToSimpleClientDto)
                .collect(Collectors.toList());
    }

    public Client getClientById(Long clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        return optionalClient.orElse(null);
    }

    public SimpleClientDto getSimpleClientDtoById(Long clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            return clientMapper.ClientToSimpleClientDto(client);
        } else {
            throw new EntityNotFoundException("The client with id: " + clientId + " was not found.");
        }
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public boolean deleteClient(Long clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            clientRepository.deleteById(clientId);
            return true;
        } else {
            return false;
        }
    }
}
