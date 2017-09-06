package org.kolokolov.boot.service;

import org.kolokolov.boot.model.Client;
import org.kolokolov.boot.repo.ClientRepository;
import static org.kolokolov.boot.model.Occupation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        populateDatabase();
    }

    private void populateDatabase() {
        clientRepository.save(new Client(0, "Bob", "Marley", SINGER));
        clientRepository.save(new Client(0, "Elvis", "Presley", SINGER));
        clientRepository.save(new Client(0, "Tom", "Waits", SINGER));
        clientRepository.save(new Client(0, "Ron", "Perlman", ACTOR));
        clientRepository.save(new Client(0, "Shaquille", "O'Neal", ATHLETE));
        clientRepository.save(new Client(0, "Ralph", "Fiennes", ACTOR));
        clientRepository.save(new Client(0, "Michael", "Jordan", ATHLETE));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        return clientRepository.findOne(id);
    }

    public Client addNewClient(Client client) {
        return clientRepository.save(client);
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