package com.example.narim.novaa;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchPageTabsAdapter extends FragmentStatePagerAdapter {
    private List<String> strings=new ArrayList<>();
    private List<Fragment>fragments=new ArrayList<>();

    public SearchPageTabsAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void AddFragment(String x, Fragment y)
    {
        strings.add(x);
        fragments.add(y);
    }
}
