package com.example.florian.mypostreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.florian.mypostreader.adapters.PostAdapter;
import com.example.florian.mypostreader.models.Post;

import java.util.List;

/**
 * Created by florian on 14/07/17.
 */

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Post post = new DataAccess().getPost("http://jsonplaceholder.typicode.com/posts/"+getIntent().getExtras().getInt("postId"));
        setTitle(post.user.username);
        TextView titleTextView = (TextView)findViewById(R.id.title);
        titleTextView.setText(post.title);
        TextView bodyTextView = (TextView)findViewById(R.id.body);
        bodyTextView.setText(post.body);
    }
}