package com.example.buttonlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class frag extends AppCompatActivity {

    Button frag1;
    Boolean a=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);

        frag1 = findViewById(R.id.btn_f);


        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a) {
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frg_holder, new BlankFragment());
                    ft.commit();
                    a=false;
                }
                else{
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frg_holder, new SecondFragment());
                    ft.commit();
                    a=true;
                }
            }
        });

    }
}
