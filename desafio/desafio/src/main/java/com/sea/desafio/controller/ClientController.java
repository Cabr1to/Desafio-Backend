package com.sea.desafio.controller;
import com.sea.desafio.model.Client;
import com.sea.desafio.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @GetMapping("{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
         clientService.saveClient(client);
        return client;
    }
//
//    @PutMapping
//    public Client updateClient(@RequestBody Client client) {
//        return clientRepository.save(client);
//
//    }

//    @DeleteMapping
//    public void deleteClient(@RequestBody Client client) {
//        clientRepository.delete(client);
//    }
}
