package com.example.buttonlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.buttonlab.module.Food;

import java.util.ArrayList;
import java.util.List;

public class recycle extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Food> foods = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recyclerView =findViewById(R.id.rvfood);
         foods.add(new Food("Momo","Buff","Rs 120",R.drawable.momo));
        foods.add(new Food("Momo","Chicken","Rs 150",R.drawable.momo));
        foods.add(new Food("Pizza","Buff","Rs 220",R.drawable.momo));
        foodAdapter adapter = new foodAdapter(foods);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
