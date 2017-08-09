package org.kolokolov.boot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Client {

    @JsonProperty
    private final int id;
    @JsonProperty("first_name")
    private final String firstName;
    @JsonProperty("last_name")
    private final String lastName;

    @JsonCreator
    public Client(@JsonProperty("id") int id,
                  @JsonProperty("first_name") String firstName,
                  @JsonProperty("last_name") String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
