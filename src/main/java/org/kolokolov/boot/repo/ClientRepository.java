package org.kolokolov.boot.repo;

import org.kolokolov.boot.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Integer> {}
