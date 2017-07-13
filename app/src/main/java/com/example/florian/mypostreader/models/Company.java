package com.example.florian.mypostreader.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by florian on 13/07/17.
 */

public class Company {
    @JsonProperty("name")
    public String name;
    @JsonProperty("catchPhrase")
    public String catchPhradse;
    @JsonProperty("bs")
    public String bs;
}
