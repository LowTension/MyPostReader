package com.example.florian.mypostreader.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONObject;

/**
 * Created by florian on 12/07/17.
 */

public class Post {
    @JsonProperty("userId")
    public int userId;
    @JsonProperty("id")
    public int id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("body")
    public String body;
    public User user;
    public Post() {
    }
}
