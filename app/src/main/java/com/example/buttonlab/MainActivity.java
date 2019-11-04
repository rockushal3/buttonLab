package com.example.buttonlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn1,btn2,btn3,btn4,btn5,btn6;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.text1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn1.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn1){
            Intent intent = new Intent(MainActivity.this,Linear.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btn2){
            Intent intent = new Intent(MainActivity.this,grid.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btn3){

        }
        if(view.getId() == R.id.btn4){
            Intent intent = new Intent(MainActivity.this,constrain.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btn5){
            Intent intent = new Intent(MainActivity.this,table.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btn6){
            Intent intent = new Intent(MainActivity.this,frame.class);
            startActivity(intent);
        }
    }
}
