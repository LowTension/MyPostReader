package com.example.florian.mypostreader.helpers;

import android.util.Log;

import com.example.florian.mypostreader.models.Post;
import com.example.florian.mypostreader.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by florian on 13/07/17.
 */

public class JsonToObject {
   public List<Post> JsonToPostList(String input){
       List<Post> result = null;
       ObjectMapper mapper = new ObjectMapper();
       try {
           result  = mapper.readValue(input, TypeFactory.defaultInstance().constructCollectionType(List.class, Post.class));
       } catch (IOException e) {
           e.printStackTrace();
       }
       return  result;
   }

    public User JsonToUser(String input) {
        User result = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            result  = mapper.readValue(input, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;
    }
}
