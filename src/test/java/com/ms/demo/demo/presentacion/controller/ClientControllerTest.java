package com.ms.demo.demo.presentacion.controller;

import com.ms.demo.demo.business.dto.ClientDto;
import com.ms.demo.demo.business.service.ClientService;
import com.ms.demo.demo.persistence.model.Client;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.*;

class ClientControllerTest {
    @Mock
    ClientService clientService;
    @InjectMocks
    ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testList() {
        List<Client> clients = Instancio.ofList(Client.class).size(4).create();

        when(clientService.list()).thenReturn(clients);

        ResponseEntity<List<Client>> result = clientController.list();
        Assertions.assertEquals(4, Objects.requireNonNull(result.getBody()).size());
        Assertions.assertEquals(result.getStatusCode().value(), HttpStatus.OK.value());
    }

    @Test
    void testAverage() {
        when(clientService.ageAverage()).thenReturn(20.0);

        ResponseEntity<Double> result = clientController.average();
        Assertions.assertEquals(20.0, Objects.requireNonNull(result.getBody()));
        Assertions.assertEquals(result.getStatusCode().value(), HttpStatus.OK.value());
    }

    @Test
    void testStandarDesviation() {
        when(clientService.standarDesviation()).thenReturn(2.3);

        ResponseEntity<Double> result = clientController.standarDesviation();
        Assertions.assertEquals(2.3, Objects.requireNonNull(result.getBody()));
        Assertions.assertEquals(result.getStatusCode().value(), HttpStatus.OK.value());
    }

    @Test
    void testGeneration() {
        when(clientService.getGeneration(anyLong())).thenReturn("Generation X");

        ResponseEntity<String> result = clientController.generation(1L);
        Assertions.assertEquals("Generation X", Objects.requireNonNull(result.getBody()));
    }

    @Test
    void testCreate() {
        Client client = Instancio.create(Client.class);

        when(clientService.create(any(ClientDto.class))).thenReturn(client);

        ResponseEntity<Void> result = clientController.create(new ClientDto());
        Assertions.assertEquals(result.getStatusCode().value(), HttpStatus.CREATED.value());
    }
}
