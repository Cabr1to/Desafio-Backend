package com.sea.desafio.controller;
import com.sea.desafio.model.Client;
import com.sea.desafio.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    @GetMapping
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping
    public Client updateClient(@RequestBody Client client) {
        return clientRepository.save(client);

    }

//    @DeleteMapping
//    public void deleteClient(@RequestBody Client client) {
//        clientRepository.delete(client);
//    }
}
