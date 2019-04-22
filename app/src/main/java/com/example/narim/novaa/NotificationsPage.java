package com.example.narim.novaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class NotificationsPage extends AppCompatActivity {

    TabLayout NotificationsTabLayout;
    ViewPager NotificationsViewPager;
    TextView NotificationsBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_page);
        NotificationsTabLayout = findViewById(R.id.TabLayout_Notifications_Tab);
        NotificationsViewPager = findViewById(R.id.ViewPager_Notification);
        NotificationsBack=findViewById(R.id.TextView_Notifications_back);
        NotificationsPageTabsAdapter adapter = new NotificationsPageTabsAdapter(getSupportFragmentManager());
        adapter.AddFragment("one", new FollowersNotificationsFragment());
        adapter.AddFragment("two", new MentionsNotificationsFragment());
        adapter.AddFragment("three", new RetweetsNotificationsFragment());
        adapter.AddFragment("four", new LikesNotificationsFragment());
        NotificationsTabLayout.setupWithViewPager(NotificationsViewPager);
        NotificationsViewPager.setAdapter(adapter);
        NotificationsTabLayout.getTabAt(0).setCustomView(R.layout.followerstabnoti);
        NotificationsTabLayout.getTabAt(1).setCustomView(R.layout.mentionstabnoti);
        NotificationsTabLayout.getTabAt(2).setCustomView(R.layout.retweetstabnoti);
        NotificationsTabLayout.getTabAt(3).setCustomView(R.layout.likestabnoti);
        NotificationsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(NotificationsPage.this,HomePage.class);
                startActivity(i);
                finish();
            }
        });


    }
}
