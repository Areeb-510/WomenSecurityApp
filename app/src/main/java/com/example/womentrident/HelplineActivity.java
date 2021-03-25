package com.example.womentrident;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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
        arr.add(new User("100","Police",R.drawable.policeman));
        arr.add(new User("102","Ambulance",R.drawable.ambulance));
        arr.add(new User("1091","Women Helpline",R.drawable.call));
        arr.add(new User("181","Women Helpline(Domestic Abuse)",R.drawable.fdgf));
        arr.add(new User("1094","Deputy Commissioner of Police",R.drawable.badge));
        arr.add(new User("1363","Tourist Helpline",R.drawable.tourist));
        arr.add(new User("1098","Children in difficulty",R.drawable.girl));


        MyAdapter adapter = new MyAdapter(this,arr);

        ListView listView = (ListView)findViewById(R.id.listview);

        listView.setAdapter(adapter);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE}, PackageManager.PERMISSION_GRANTED);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User users = arr.get(position);

                String ph = arr.get(position).getNumber();

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ph));
                startActivity(intent);

            }
        });

    }
}