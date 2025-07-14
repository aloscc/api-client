package com.ms.demo.demo.business.service;

import com.ms.demo.demo.business.dto.ClientDto;
import com.ms.demo.demo.persistence.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> list();

    Client create(ClientDto clientDto);

    double ageAverage();

    double standarDesviation();

    String getGeneration(Long id);

}
