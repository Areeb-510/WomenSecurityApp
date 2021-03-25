package com.example.womentrident;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addNumbers extends AppCompatActivity {

    FirebaseDatabase rootnode;
    DatabaseReference databaseReference;
    EditText numbers;
    Button btn;


    public addNumbers() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_numbers);






        numbers = (EditText)findViewById(R.id.numbers);

        btn = (Button)findViewById(R.id.btn);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Contacts");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertContactInfo();


            }
        });



    }
//    public String getNumber() {
//        String number = numbers.getText().toString();
//        return number;
//
//    }

    private void insertContactInfo() {

        String number = numbers.getText().toString();
        if (number.length() == 0 && number.isEmpty()) {
            Toast.makeText(this, "Please enter phone number", Toast.LENGTH_SHORT).show();
        } else if (number.length() < 10) {

        } else if (number.length() == 10) {
            ContactData contactData = new ContactData(number);
            String key = databaseReference.push().getKey();
            databaseReference.child(key).setValue(contactData);
            Log.e("insertContactInfo: ", key);

            // using shared preferences to store the key for the entered number by user
            SharedPreferences sharedPreferences = getSharedPreferences("Contact_Number", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("reference_id", key);
            editor.apply();

            Toast.makeText(this, "Number added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
        }
    }
}