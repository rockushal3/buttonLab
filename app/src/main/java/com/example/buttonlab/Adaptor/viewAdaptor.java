package com.example.buttonlab.Adaptor;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewAdaptor extends FragmentPagerAdapter {
   private List<Fragment> fragmentList = new ArrayList<>();
   private List<String> titleList =new ArrayList<>();

    public viewAdaptor(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    public void addFragments(Fragment fragment, String title){
        fragmentList.add(fragment);
        titleList.add(title);
    }
}
