package com.example.florian.mypostreader;

import android.os.AsyncTask;

import com.example.florian.mypostreader.helpers.JsonToObject;
import com.example.florian.mypostreader.models.Post;
import com.example.florian.mypostreader.models.User;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by florian on 12/07/17.
 */

public class DataAccess extends AsyncTask<String, Void, String> {

    HttpURLConnection urlConnection;

    @Override
    protected String doInBackground(String... args) {

        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(args[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

        }catch( Exception e) {
            e.printStackTrace();
        }
        finally {
            urlConnection.disconnect();
        }
        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {

        //Do something with the JSON string
    }

    private String returnResult (String input) {
        //handle value
        return input;
    }

    public List<Post> getPosts(String url) {
        List<Post> posts = null;
        try {
            posts = new JsonToObject().JsonToPostList(new DataAccess().execute(url).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        for (Post p : posts) {
            p.user  =  new DataAccess().getUser("https://jsonplaceholder.typicode.com/users/"+p.userId);
        }
        return posts;
    }
    public User getUser(String url) {
        User user = null;
        try {
            user = new JsonToObject().JsonToUser(new DataAccess().execute(url).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return user;
    }
}
