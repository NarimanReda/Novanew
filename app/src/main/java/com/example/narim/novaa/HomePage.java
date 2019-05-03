package com.example.narim.novaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView Home;
    ImageView Search;
    ImageView Profile;
    ImageView Notifications;
    ImageView PostTweet;
    RecyclerView TweetRecView;
    List<Tweets> tweets= new ArrayList<>();

    ImageView iOpenMenu;
    DrawerLayout drawer;
    NavigationView navigationView;

    TextView NavDrawer_Profile;
    TextView NavDrawer_Following;
    TextView NavDrawer_Followers;
    TextView NavDrawer_EditProfile;


    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String name= getIntent().getStringExtra("name");
        final String id= getIntent().getStringExtra("id");
        final String followerscount=getIntent().getStringExtra("followersCount");
        final String favoritesCount=getIntent().getStringExtra("favoritesCount");
        final String Novascount=getIntent().getStringExtra("novasCount");
        final String email=getIntent().getStringExtra("email");
        final String screenname=getIntent().getStringExtra("screenname");
        final String verified=getIntent().getStringExtra("verified");
        final String friendscout=getIntent().getStringExtra("friendsCount");
        final String novascount=getIntent().getStringExtra("Novascount");
        final String token=getIntent().getStringExtra("token");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Home= findViewById(R.id.Icon_Home_Home);
        Search= findViewById(R.id.Icon_Home_Search);
        Profile=findViewById(R.id.Icon_Home_Profile);
        Notifications= findViewById(R.id.Icon_Home_Notifs);
        PostTweet= findViewById(R.id.Icon_Home_PostTweet);
        TweetRecView=findViewById(R.id.RecyclerView_Home_Tweets);


        iOpenMenu = findViewById(R.id.image_Home_Photo);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView  navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        NavDrawer_Profile = findViewById(R.id.Textview_NavDrawer_Profile);
        NavDrawer_Following = findViewById(R.id.Textview_NavDrawer_Following);
        NavDrawer_Followers = findViewById(R.id.Textview_NavDrawer_Followers);
        NavDrawer_EditProfile = findViewById(R.id.Textview_NavDrawer_EditProfile);
        ImageView profilepicture= findViewById(R.id.image_NavDrawer_profilepic);

        String Name[]={"Dina Walid","Menna Walid", "Arwa Walid","Ziad Walid"};
        String ScreenName[]={"dinawalid","mennawalid","arwawalid","ziadwalid"};
        String TweetText[]={"Hi, I'm dina","Hi, I'm menna","Hi, I'm arwa","Hi, I'm ziad"};
        String RetweetNumber[]={"1","2","3","4"};
        String RepliesNumber[]={"1","2","3","4"};
        String LikesNumber[]={"1","2","3","4"};
        for(int i=0; i<Name.length; i++)
        {
            Tweets tweet =new Tweets(Name[i],ScreenName[i],TweetText[i],RetweetNumber[i],RepliesNumber[i],LikesNumber[i]);
            tweets.add(tweet);
        }
        TweetRecView.setLayoutManager(new LinearLayoutManager(HomePage.this));
        TweetsAdapter tweetsAdapter=new TweetsAdapter(tweets);
        TweetRecView.setAdapter(tweetsAdapter);

        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,ProfilePage.class);
                i.putExtra("token",token);
                i.putExtra("name",name);
                i.putExtra("screenname",screenname);
                i.putExtra("verified",verified);
                i.putExtra("followersCount",followerscount);
                i.putExtra("favoritesCount",favoritesCount);
                i.putExtra("friendsCount",friendscout);
                i.putExtra("novasCount",novascount);
                i.putExtra("id",id);
                i.putExtra("email",email);
                startActivity(i);
                finish();

            }
        });
        Notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,NotificationsPage.class);
                startActivity(intent);
                finish();
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,Search.class);
                startActivity(intent);
                finish();
            }
        });
        PostTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostTweet alertDialog= new PostTweet();
                FragmentManager f=getSupportFragmentManager();
                alertDialog.show(f, "fragment_alert");
            }
        });


        iOpenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("asdksad",":aslsa");
                if (drawer.isDrawerOpen(Gravity.START)) {
                    drawer.closeDrawer(Gravity.START);
                } else {
                    drawer.openDrawer(Gravity.START);
                }
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id)
        {
            case R.id.Textview_NavDrawer_Profile:
                Intent h =new Intent(HomePage.this,ProfilePage.class);
                startActivity(h);
                finish();
                break;

            case R.id.Textview_NavDrawer_Following:
                Intent g =new Intent(HomePage.this,Following.class);
                startActivity(g);
                finish();
                break;

            case R.id.Textview_NavDrawer_Followers:
                Intent k =new Intent(HomePage.this,Followers.class);
                startActivity(k);
                finish();
                break;

            case R.id.Textview_NavDrawer_EditProfile:
                Intent i =new Intent(HomePage.this,EditProfile.class);
                startActivity(i);
                finish();
                break;
        }
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(Gravity.START);
        return true;
    }

}