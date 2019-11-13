package com.example.buttonlab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buttonlab.module.Food;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class foodAdapter extends RecyclerView.Adapter<foodAdapter.MyHolder>{

    List<Food> foodList = new ArrayList<>();

    public foodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycle_food,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Food food = foodList.get(position);
        holder.tname.setText(food.getName());
        holder.ttype.setText(food.getCateg());
        holder.tprice.setText(food.getRate());
        holder.imageView.setImageResource(food.getImg());

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tname,ttype,tprice;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.foodImg);
            tname = itemView.findViewById(R.id.foodName);
            ttype = itemView.findViewById(R.id.foodType);
            tprice = itemView.findViewById(R.id.foodprice);
        }
    }
}
