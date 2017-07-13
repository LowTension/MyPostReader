package com.example.florian.mypostreader.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by florian on 12/07/17.
 */

public class User {
    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("username")
    public String username;
    @JsonProperty("email")
    public String email;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("website")
    public String website;
    @JsonProperty("address")
    public Adress address;
    @JsonProperty("company")
    public Company company;

    public User() {
    }
}
