package org.kolokolov.boot.rest;

import org.kolokolov.boot.model.OrderItem;
import org.kolokolov.boot.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/rest")
public class Controller {

    private final OrderItemService orderItemService;

    @Autowired
    public Controller(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @RequestMapping(value = "/items",method = GET)
    public List<OrderItem> getAllItems() {
        return orderItemService.getAllItems();
    }

    @RequestMapping(value = "/items",method = POST)
    public void addNewItem(@RequestBody(required = true) OrderItem item) {
        orderItemService.addNewItem(item);
    }
}
