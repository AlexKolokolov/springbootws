package org.kolokolov.boot.service;

import org.kolokolov.boot.model.Product;
import org.kolokolov.boot.model.Vendor;
import org.kolokolov.boot.repo.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static org.kolokolov.boot.model.Occupation.*;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
        populateDatabase();
    }

    private void populateDatabase() {
        vendorRepository.save(new Vendor("Colt", Arrays.asList(new Product("1911"),new Product("M4"))));
        vendorRepository.save(new Vendor("FN", Arrays.asList(new Product("P90"),new Product("FiveSeven"))));
        vendorRepository.save(new Vendor("H&K", Arrays.asList(new Product("MP5"),new Product("G36"))));
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Vendor getVendorById(int id) {
        return vendorRepository.findOne(id);
    }

    public Vendor addNewVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public void updateVendor(int id, Vendor vendor) {
        if (id > 0) {
            vendor.setId(id);
            vendorRepository.save(vendor);
        } else throw new IllegalArgumentException("Vendor ID should be positive integer");
    }

    public void deleteVendorById(int id) {
        vendorRepository.delete(id);
    }
}