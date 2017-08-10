package org.kolokolov.boot.model;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int amount;

    public OrderItem() {}

    public OrderItem(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
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
}
