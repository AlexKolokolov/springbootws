package org.kolokolov.boot.service;

import org.kolokolov.boot.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService {

    private final List<OrderItem> items = new ArrayList<>();

    {
        items.add(new OrderItem("1911",2));
        items.add(new OrderItem("P90",3));
        items.add(new OrderItem("FiveSeven",5));
    }

    public List<OrderItem> getAllItems() {
        return items;
    }

    public void addNewItem(OrderItem item) {
        items.add(item);
    }
}
