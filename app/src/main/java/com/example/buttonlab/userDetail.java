package com.example.buttonlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class userDetail extends AppCompatActivity {

    TextView name, gender,email,dob,phone,country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        name= findViewById(R.id.name1);
        country= findViewById(R.id.country);
        email= findViewById(R.id.email);
        dob = findViewById(R.id.dob);
        phone = findViewById(R.id.phone);
        gender= findViewById(R.id.gender);

        Intent intent = getIntent();
        String Myvalue = intent.getStringExtra("Name");
        String Myvalue1 = intent.getStringExtra("Country");
        String Myvalue3 = intent.getStringExtra("Gender");
        String Myvalue4 = intent.getStringExtra("DoB");
        String Myvalue5 = intent.getStringExtra("Email");
        String Myvalue6 = intent.getStringExtra("Phone");
        name.setText(Myvalue);
        country.setText(Myvalue1);
        gender.setText(Myvalue3);
        email.setText(Myvalue5);
        dob.setText(Myvalue4);
        phone.setText(Myvalue6);
    }
}
