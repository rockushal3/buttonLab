package com.example.buttonlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listdata extends AppCompatActivity {
    ListView listview;
    String[] test = {"a","b","c"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);
        listview = findViewById(R.id.lview);
        ArrayAdapter  adapter =new ArrayAdapter(this,R.layout.countryname,test);
        listview.setAdapter(adapter);

    }
}
