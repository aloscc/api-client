package com.ms.demo.demo.presentacion.controller;

import com.ms.demo.demo.business.dto.ClientDto;
import com.ms.demo.demo.business.service.ClientService;
import com.ms.demo.demo.persistence.model.Client;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@Validated
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public ResponseEntity<List<Client>> list() {
        return new ResponseEntity<>(clientService.list(), HttpStatus.OK);
    }

    @GetMapping("/average")
    public ResponseEntity<Double> average() {
        return new ResponseEntity<>(clientService.ageAverage(), HttpStatus.OK);
    }

    @GetMapping("/stddev")
    public ResponseEntity<Double> standarDesviation() {
        return new ResponseEntity<>(clientService.standarDesviation(), HttpStatus.OK);
    }

    @GetMapping("/generation/{id}")
    public ResponseEntity<String> generation(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.getGeneration(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ClientDto request) {
        clientService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
