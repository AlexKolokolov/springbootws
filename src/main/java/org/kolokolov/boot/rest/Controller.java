package org.kolokolov.boot.rest;

import org.kolokolov.boot.model.Client;
import org.kolokolov.boot.model.Order;
import org.kolokolov.boot.service.ClientService;
import org.kolokolov.boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/rest")
public class Controller {

    private final OrderService orderService;
    private final ClientService clientService;

    @Autowired
    public Controller(OrderService orderItemService,ClientService clientService) {
        this.orderService = orderItemService;
        this.clientService = clientService;
    }

    @RequestMapping(value = "/orders",method = GET)
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/orders",method = POST)
    public void addNewOrder(@RequestBody(required = true) Order order) {
        orderService.addNewOrder(order);
    }

    @RequestMapping(value = "/clients",method = GET)
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/clients",method = POST)
    public void addNewClient(@RequestBody(required = true) Client client) {
        clientService.addNewClient(client);
    }
}
