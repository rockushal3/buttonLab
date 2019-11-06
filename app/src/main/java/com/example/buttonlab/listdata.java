package com.example.buttonlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.buttonlab.module.User;

import java.util.List;

public class listdata extends AppCompatActivity {
    ListView listview;
    String[] test = {"a","b","c"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);
        listview = findViewById(R.id.lview);
        Intent intent = getIntent();
        final List<User> userList= (List<User>) intent.getSerializableExtra("allusers");
        String[] userNames = new String[userList.size()];
        int i =0;
        for(User user:userList){
            userNames[i] = user.getName();
            i++;
        }

        final ArrayAdapter  adapter =new ArrayAdapter(this,R.layout.countryname,userNames);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent1 = new Intent(listdata.this,userDetail.class);
                intent1.putExtra("Name",userList.get(position).getName());
                intent1.putExtra("Gender",userList.get(position).getGender());
                intent1.putExtra("DoB",userList.get(position).getDob());
                intent1.putExtra("Country",userList.get(position).getCountry());
                intent1.putExtra("Phone",userList.get(position).getPhone());
                intent1.putExtra("Email",userList.get(position).getEmail());
                startActivity(intent1);
            }
        });
    }
}
