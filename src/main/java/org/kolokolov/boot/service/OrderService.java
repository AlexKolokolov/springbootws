package org.kolokolov.boot.service;

import org.kolokolov.boot.model.ShopOrder;
import org.kolokolov.boot.model.OrderItem;
import org.kolokolov.boot.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        populateDatabase();
    }

    private void populateDatabase() {
        orderRepository.save(new ShopOrder(0, new ArrayList<>(Arrays.asList(
                new OrderItem(0,"1911",2),
                new OrderItem(0,"MP5",3)
        ))));
        orderRepository.save(new ShopOrder(0, new ArrayList<>(Arrays.asList(
                new OrderItem(0,"FiveSeven",2),
                new OrderItem(0,"P90",3)
        ))));
    }

    public List<ShopOrder> getAllOrders() {
        List<ShopOrder> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    public void addNewOrder(ShopOrder order) {
        orderRepository.save(order);
    }
}