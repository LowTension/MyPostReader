package com.example.florian.mypostreader.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by florian on 13/07/17.
 */

public class Geo {
    @JsonProperty("lat")
    public float lat;
    @JsonProperty("lng")
    public float lng;
}
