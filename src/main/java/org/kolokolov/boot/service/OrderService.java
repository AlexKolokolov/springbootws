package org.kolokolov.boot.service;

import org.kolokolov.boot.model.Order;
import org.kolokolov.boot.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final List<Order> orders = new ArrayList<>();

    {
        List<OrderItem> items1 = new ArrayList<>();
        items1.add(new OrderItem("1911",2));
        items1.add(new OrderItem("MP5",3));
        orders.add(new Order(items1));

        List<OrderItem> items2 = new ArrayList<>();
        items2.add(new OrderItem("FiveSeven",2));
        items2.add(new OrderItem("P90",3));
        orders.add(new Order(items2));
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void addNewOrder(Order order) {
        orders.add(order);
    }
}
