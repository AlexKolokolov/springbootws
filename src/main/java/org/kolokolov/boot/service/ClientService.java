package org.kolokolov.boot.service;

import org.kolokolov.boot.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private final List<Client> clients = new ArrayList<>();

    {
        clients.add(new Client(1, "Bob", "Marley"));
        clients.add(new Client(2, "Elvis", "Presley"));
        clients.add(new Client(3, "Tom", "Waits"));
        clients.add(new Client(4, "Ron", "Perlman"));
    }

    public List<Client> getAllClients() {
        return clients;
    }

    public void addNewClient(Client client) {
        clients.add(client);
    }
}
