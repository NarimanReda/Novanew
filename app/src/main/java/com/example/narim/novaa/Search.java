package com.example.narim.novaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Search extends AppCompatActivity {

    TabLayout SearchTabLayout;
    ViewPager SearchViewPager;
    TextView SearchBack;
    Button FollowButton;
    TextView Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        SearchTabLayout = findViewById(R.id.TabLayout_Search_Tab);
        SearchViewPager = findViewById(R.id.ViewPager_Notification);
        SearchBack = findViewById(R.id.TextView_Search_back);
        Search = findViewById(R.id.TextView_Search_SearchLogo);
        FollowButton = findViewById(R.id.Button_Profile_Follow);
        SearchPageTabsAdapter adapter = new SearchPageTabsAdapter(getSupportFragmentManager());
        adapter.AddFragment("one", new ProfileSearchFragment());
        adapter.AddFragment("two", new TweetsSearchFragment());
        SearchTabLayout.setupWithViewPager(SearchViewPager);
        SearchViewPager.setAdapter(adapter);
        SearchTabLayout.getTabAt(0).setCustomView(R.layout.profiles_tab_search);
        SearchTabLayout.getTabAt(1).setCustomView(R.layout.novas_tab_search);
        SearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Search.this,HomePage.class);
                startActivity(i);
                finish();
            }
        });
    }
}
