package org.kolokolov.boot.repo;

import org.kolokolov.boot.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor,Integer> {}
