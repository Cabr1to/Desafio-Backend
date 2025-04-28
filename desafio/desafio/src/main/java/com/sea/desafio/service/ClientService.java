package com.sea.desafio.service;

import com.sea.desafio.model.Client;
import com.sea.desafio.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(
            ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException (id + " não encontrado" ));
    }

    public void saveClient(Client client) {
         clientRepository.save(client);
    }

    public Client updateClient(Client client) {
        getClientById(client.getId());
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        getClientById(id);
        clientRepository.deleteById(id);
    }
}
