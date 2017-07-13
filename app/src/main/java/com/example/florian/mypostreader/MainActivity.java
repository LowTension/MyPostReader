package com.example.florian.mypostreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.florian.mypostreader.adapters.PostAdapter;
import com.example.florian.mypostreader.models.Post;
import com.example.florian.mypostreader.models.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView postListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postListView = (ListView) findViewById(R.id.listView);

        //Récuperation de la liste de posts
        List<Post> posts = new DataAccess().getPosts("http://jsonplaceholder.typicode.com/posts");

        PostAdapter adapter = new PostAdapter(MainActivity.this, posts);
        postListView.setAdapter(adapter);
    }
}
