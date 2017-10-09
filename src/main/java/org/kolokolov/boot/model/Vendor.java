package org.kolokolov.boot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @JsonProperty("text")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(value = CascadeType.PERSIST)
    @JsonProperty("children")
    private List<Product> products;

    public Vendor() {}

    public Vendor(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}