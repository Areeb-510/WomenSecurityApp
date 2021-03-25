package com.example.womentrident;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
                if(number.equals(""))
                {
                    Toast.makeText(this, "Please Recheck your Input ", Toast.LENGTH_SHORT).show();

                }
                else
                    {

                    ContactData contactData = new ContactData(number);

                    databaseReference.push().setValue(contactData);
                    Toast.makeText(this, "Number added", Toast.LENGTH_SHORT).show();
                }
    }
}