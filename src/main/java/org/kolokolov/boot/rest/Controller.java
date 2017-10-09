package org.kolokolov.boot.rest;

import org.kolokolov.boot.model.Client;
import org.kolokolov.boot.model.ShopOrder;
import org.kolokolov.boot.model.Vendor;
import org.kolokolov.boot.service.ClientService;
import org.kolokolov.boot.service.OrderService;
import org.kolokolov.boot.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/rest")
public class Controller {

    private final OrderService orderService;
    private final ClientService clientService;
    private final VendorService vendorService;


    @Autowired
    public Controller(OrderService orderItemService,ClientService clientService,VendorService vendorService) {
        this.orderService = orderItemService;
        this.clientService = clientService;
        this.vendorService = vendorService;
    }

    @RequestMapping(value = "/orders",method = GET)
    public List<ShopOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/orders",method = POST)
    public void addNewOrder(@RequestBody(required = true) ShopOrder order) {
        orderService.addNewOrder(order);
    }

    @RequestMapping(value = "/vendors",method = GET)
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @RequestMapping(value = "/vendors",method = POST)
    public void addNewOrder(@RequestBody(required = true) Vendor vendor) {
        vendorService.addNewVendor(vendor);
    }

    @RequestMapping(value = "/clients",method = GET)
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/clients",method = POST)
    public int addNewClient(@RequestBody(required = false) Client client) {
        if (client != null) return clientService.addNewClient(client).getId();
        return -1;
    }

    @RequestMapping(value = "/clients/{id}", method = GET)
    public Client getClientById(@PathVariable(required = true) int id) {
        return clientService.getClientById(id);
    }

    @RequestMapping(value = "/clients/{id}",method = PUT)
    public void updateClient(
            @RequestBody(required = true) Client client,
            @PathVariable(required = true) int id) {
        clientService.updateClient(id,client);
    }

    @RequestMapping(value = "/clients/{id}",method = DELETE)
    public void updateClient(@PathVariable(required = true) int id) {
        clientService.deleteClientById(id);
    }
}