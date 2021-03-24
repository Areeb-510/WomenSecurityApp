package com.example.womentrident;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HelplineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        final ArrayList<User> arr = new ArrayList<User>();
        arr.add(new User("9410264395","Police",R.drawable.policeman));
        arr.add(new User("12","Ambulance",R.drawable.ambulance));
        arr.add(new User("10","Women Helpline",R.drawable.call));

        MyAdapter adapter = new MyAdapter(this,arr);

        ListView listView = (ListView)findViewById(R.id.listview);

        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                User users = arr.get(position);
//
//                String ph = arr.get(position).getNumber();
//
//                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ph));
//                startActivity(intent);
//
//            }
//        });

    }
}