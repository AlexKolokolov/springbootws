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
        ShopOrder shopOrder1 = new ShopOrder();
        shopOrder1.setItems(Arrays.asList(
                new OrderItem(0,"1911",2,shopOrder1),
                new OrderItem(0,"MP5",3,shopOrder1)
        ));

        ShopOrder shopOrder2 = new ShopOrder();
        shopOrder2.setItems(Arrays.asList(
                new OrderItem(0,"FiveSeven",2,shopOrder2),
                new OrderItem(0,"P90",3,shopOrder2)
        ));
        orderRepository.save(shopOrder1);
        orderRepository.save(shopOrder2);
    }

    public List<ShopOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public void addNewOrder(ShopOrder order) {
        orderRepository.save(order);
    }
}