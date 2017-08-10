package org.kolokolov.boot.service;

import org.kolokolov.boot.model.Client;
import org.kolokolov.boot.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        clientRepository.save(new Client(1, "Bob", "Marley"));
        clientRepository.save(new Client(2, "Elvis", "Presley"));
        clientRepository.save(new Client(3, "Tom", "Waits"));
        clientRepository.save(new Client(4, "Ron", "Perlman"));
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    public Client getClientById(int id) {
        return clientRepository.findOne(id);
    }

    public void addNewClient(Client client) {
        clientRepository.save(client);
    }

    public void updateClient(int id, Client client) {
        if (id > 0) {
            client.setId(id);
            clientRepository.save(client);
        } else throw new IllegalArgumentException("Client ID should be positive integer");
    }

    public void deleteClientById(int id) {
        clientRepository.delete(id);
    }
}
