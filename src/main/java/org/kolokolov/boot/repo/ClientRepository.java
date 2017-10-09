package org.kolokolov.boot.repo;

import org.kolokolov.boot.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {}
