package org.kolokolov.boot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Order {

    @JsonProperty
    private final List<OrderItem> items;

    @JsonCreator
    public Order(@JsonProperty("items") List<OrderItem> items) {
        this.items = items;
    }
}
