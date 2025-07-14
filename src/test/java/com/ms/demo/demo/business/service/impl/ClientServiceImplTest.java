package com.ms.demo.demo.business.service.impl;

import com.ms.demo.demo.business.dto.ClientDto;
import com.ms.demo.demo.persistence.model.Client;
import com.ms.demo.demo.persistence.repository.ClientRepository;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class ClientServiceImplTest {
    @Mock
    ClientRepository clientRepository;
    @InjectMocks
    ClientServiceImpl clientServiceImpl;

    private Client client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = Instancio.create(Client.class);
    }

    @Test
    void testList() {

        when(clientRepository.findAll()).thenReturn(List.of(client));

        List<Client> result = clientServiceImpl.list();

        Assertions.assertEquals(List.of(client), result);
    }

    @Test
    void testCreate() {
        ClientDto clientDto = Instancio.create(ClientDto.class);

        when(clientRepository.save(any(Client.class))).thenReturn(client);

        Client result = clientServiceImpl.create(clientDto);
        Assertions.assertNotNull(result);
    }

    @Test
    void testAgeAverage() {
        when(clientRepository.averageAge()).thenReturn(Double.valueOf(10));

        double result = clientServiceImpl.ageAverage();
        Assertions.assertEquals(10, result);
    }

    @Test
    void testStandarDesviation() {
        when(clientRepository.stddev()).thenReturn(Double.valueOf(10));

        double result = clientServiceImpl.standarDesviation();
        Assertions.assertEquals(10, result);
    }

    @Test
    void testGetGeneration() {
        when(clientRepository.yearBirth(anyLong())).thenReturn(Optional.of("Generation X"));

        String result = clientServiceImpl.getGeneration(1L);
        Assertions.assertEquals("Generation X", result);
    }
}
