package com.example.womentrident;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HelplineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        final ArrayList<User> arr = new ArrayList<User>();
        arr.add(new User("100","Police",R.drawable.policeman));
        arr.add(new User("102","Ambulance",R.drawable.ambulance));
        arr.add(new User("1091","Women Helpline",R.drawable.call));

        MyAdapter adapter = new MyAdapter(this,arr);

        ListView listView = (ListView)findViewById(R.id.listview);

        listView.setAdapter(adapter);


    }
}