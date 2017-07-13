package com.example.florian.mypostreader.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by florian on 13/07/17.
 */

public class Adress {
    @JsonProperty("street")
    public String street;
    @JsonProperty("suite")
    public String suite;
    @JsonProperty("city")
    public String city;
    @JsonProperty("zipcode")
    public String zipcode;
    @JsonProperty("geo")
    public Geo geo;
}
