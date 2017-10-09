package org.kolokolov.boot.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShopOrder {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonManagedReference
    @JoinColumn(name = "shop_order_id")
    private List<OrderItem> items;

    public ShopOrder() {}

    public ShopOrder(int id, List<OrderItem> items) {
        this.id = id;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}