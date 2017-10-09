package org.kolokolov.boot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int amount;

    @ManyToOne
    @JsonBackReference
    private ShopOrder shopOrder;

    public OrderItem() {}

    public OrderItem(int id, String name, int amount, ShopOrder shopOrder) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.shopOrder = shopOrder;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public ShopOrder getShopOrder() {
        return shopOrder;
    }
}