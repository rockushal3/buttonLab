package com.example.buttonlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.buttonlab.Adaptor.viewAdaptor;
import com.google.android.material.tabs.TabLayout;

public class Tab extends AppCompatActivity {

    TabLayout myTab;
    ViewPager myPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        myTab = findViewById(R.id.myTab);
        myPager = findViewById(R.id.myPager);

        FragmentManager fm = getSupportFragmentManager();
        viewAdaptor viewAdaptor = new viewAdaptor(fm);
        viewAdaptor.addFragments(new BlankFragment(),"First");
        viewAdaptor.addFragments(new SecondFragment(),"Second");
        myPager.setAdapter(viewAdaptor);
        myTab.setupWithViewPager(myPager);


    }
}
