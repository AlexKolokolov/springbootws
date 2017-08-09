package org.kolokolov.boot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItem {

    @JsonProperty
    private final String name;

    @JsonProperty
    private final int amount;

    @JsonCreator
    public OrderItem(@JsonProperty("name") String name, @JsonProperty("amount") int amount) {
        this.name = name;
        this.amount = amount;
    }
}
