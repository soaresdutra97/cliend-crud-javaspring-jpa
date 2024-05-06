package com.example.clientsystem.controllers;


import com.example.clientsystem.domain.client.Client;
import com.example.clientsystem.domain.client.ProductRepository;
import com.example.clientsystem.domain.client.RequestClient;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllClients(){
        var allClients = repository.findAllByActiveTrue();
        return ResponseEntity.ok(allClients);
    }

    @PostMapping
    public ResponseEntity registerClient(@RequestBody @Valid RequestClient data){
        Client newClient = new Client(data);
        repository.save(newClient);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateClient(@RequestBody @Valid RequestClient data){
        Optional<Client> optionalClient = repository.findById(data.id());
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setName(data.name());
            client.setEmail(data.email());
            return ResponseEntity.ok(client);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteClient(@PathVariable String id){
        Optional<Client> optionalClient = repository.findById(id);
        if (optionalClient.isPresent()){
            Client client = optionalClient.get();
            client.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}