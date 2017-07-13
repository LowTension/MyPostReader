package com.example.florian.mypostreader.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.florian.mypostreader.R;
import com.example.florian.mypostreader.models.Post;

import java.util.List;

/**
 * Created by florian on 12/07/17.
 */

public class PostAdapter extends ArrayAdapter<Post> {

    //tweets est la liste des models à afficher
    public PostAdapter(Context context, List<Post> posts) {
        super(context, 0, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_post,parent, false);
        }

        PostViewHolder viewHolder = (PostViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new PostViewHolder();
            viewHolder.user = (TextView) convertView.findViewById(R.id.user);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Post> posts
        Post post = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.user.setText(post.user.username);
        viewHolder.title.setText(post.title);

        return convertView;
    }

    private class PostViewHolder{
        public TextView user;
        public TextView title;
    }
}
