package com.ms.demo.demo.business.service.impl;

import com.ms.demo.demo.business.dto.ClientDto;
import com.ms.demo.demo.business.service.ClientService;
import com.ms.demo.demo.persistence.model.Client;
import com.ms.demo.demo.persistence.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @Override
    public Client create(ClientDto clientDto) {
        Client newClient = new Client();
        newClient.setFirstname(clientDto.getFirstname());
        newClient.setLastname(clientDto.getLastname());
        newClient.setAge(clientDto.getAge());
        newClient.setBirthday(clientDto.getBirthday());

        return clientRepository.save(newClient);
    }

    @Override
    public double ageAverage() {
        return clientRepository.averageAge();
    }

    @Override
    public double standarDesviation() {
        return clientRepository.stddev();
    }

    @Override
    public String getGeneration(Long id) {
        return clientRepository.yearBirth(id).orElse("Client doesn't exist");
    }

}
