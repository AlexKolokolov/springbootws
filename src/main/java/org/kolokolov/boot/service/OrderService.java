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
        ShopOrder order1 = new ShopOrder();
        List<OrderItem> order1items = Arrays.asList(
                new OrderItem(0,"1911",2),
                new OrderItem(0,"MP5",3));
        order1.setItems(order1items);
        orderRepository.saveAndFlush(order1);

        ShopOrder order2 = new ShopOrder();
        List<OrderItem> order2items = Arrays.asList(
                new OrderItem(0,"FiveSeven",2),
                new OrderItem(0,"P90",3));
        order2.setItems(order2items);
        orderRepository.saveAndFlush(order2);
    }

    public List<ShopOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public ShopOrder getOrderById(int id) {
        return  orderRepository.findOne(id);
    }

    public void addNewOrder(ShopOrder order) {
        orderRepository.save(order);
    }
}