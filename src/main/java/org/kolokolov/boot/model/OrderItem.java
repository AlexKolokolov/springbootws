package org.kolokolov.boot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItem {

    @JsonProperty
    private String name;
    @JsonProperty
    private int amount;

    public OrderItem() {}

    public OrderItem(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}
