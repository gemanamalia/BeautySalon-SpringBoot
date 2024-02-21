package com.unibuc.beautysalon.service;

import com.unibuc.beautysalon.dto.SimpleClientDto;
import com.unibuc.beautysalon.entity.Client;
import com.unibuc.beautysalon.mapper.ClientMapper;
import com.unibuc.beautysalon.repository.ClientRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientService clientService;

    private Client testClient;
    @BeforeEach
    void setUp() {
        testClient = new Client();
        testClient.setId(1L);
        testClient.setName("Test Client 1");
    }

    @Test
    void getAllClients() {
        List<Client> clients = Arrays.asList(testClient, new Client(2L, "Test Client 2"));
        Mockito.when(clientRepository.findAll()).thenReturn(clients);

        List<Client> result = clientService.getAllClients();

        assertEquals(2, result.size());
        assertEquals("Test Client 1", result.get(0).getName());
    }

    @Test
    void getClientById() {
        Long clientId = 1L;
        Client client = new Client();
        when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));

        Client result = clientService.getClientById(clientId);

        assertNotNull(result);
        assertEquals(client, result);
    }

    @Test
    void getSimpleClientDtoById() {
        Long clientId = 1L;
        Client client = new Client();
        SimpleClientDto expected = new SimpleClientDto();
        when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));
        when(clientMapper.ClientToSimpleClientDto(client)).thenReturn(expected);

        SimpleClientDto result = clientService.getSimpleClientDtoById(clientId);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void saveClient() {
        Client client = new Client();
        when(clientRepository.save(client)).thenReturn(client);

        Client result = clientService.saveClient(client);

        assertNotNull(result);
        assertEquals(client, result);
    }

    @Test
    void deleteClient() {
        Long clientId = 1L;
        when(clientRepository.findById(clientId)).thenReturn(Optional.of(new Client()));

        boolean result = clientService.deleteClient(clientId);

        assertTrue(result);
        verify(clientRepository, times(1)).deleteById(clientId);
    }
}
