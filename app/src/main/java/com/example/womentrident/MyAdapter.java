package com.example.womentrident;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<User> {
    public MyAdapter(Activity context, ArrayList<User> arr){
        super(context,0,arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView= convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.row,parent,false);
        }

        User currentuser = getItem(position);
        TextView maintitle = (TextView)listItemView.findViewById(R.id.maintitle);
        maintitle.setText(currentuser.getName());

        TextView subtitle = (TextView)listItemView.findViewById(R.id.subtitle);
        subtitle.setText(currentuser.getNumber());

        ImageView image = (ImageView)listItemView.findViewById(R.id.image);
        image.setImageResource(currentuser.getImageid());

        return listItemView;
    }
}
