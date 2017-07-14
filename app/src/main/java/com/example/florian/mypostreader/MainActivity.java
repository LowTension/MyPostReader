package com.example.florian.mypostreader;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        setTitle("Posts");
        //Récuperation de la liste de posts
        List<Post> posts = new DataAccess().getPosts("http://jsonplaceholder.typicode.com/posts");
        postListView = (ListView) findViewById(R.id.listView);
        postListView.setClickable(true);
        PostAdapter adapter = new PostAdapter(MainActivity.this, posts);
        postListView.setAdapter(adapter);
        postListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapter,View v, int position, long t){
                Post post = (Post)adapter.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("postId",post.id);
                startActivity(intent);
            }
        });
    }
}
