package org.kolokolov.boot.model;

import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.List;

@Entity
public class ShopOrder {

    @Id
    @GeneratedValue
    private int id;
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
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
}
