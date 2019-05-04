package com.example.narim.novaa;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

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
    ImageView nav_photo_opener ;
    DrawerLayout drawer;

    protected void onCreate(Bundle savedInstanceState) {
        final String name = getIntent().getStringExtra("name");
        final String id = getIntent().getStringExtra("id");
        final String followerscount = getIntent().getStringExtra("followersCount");
        final String favoritesCount = getIntent().getStringExtra("favoritesCount");
        final String Novascount = getIntent().getStringExtra("novasCount");
        final String email = getIntent().getStringExtra("email");
        final String screenname = getIntent().getStringExtra("screenname");
        final String verified = getIntent().getStringExtra("verified");
        final String friendscout = getIntent().getStringExtra("friendsCount");
        final String novascount = getIntent().getStringExtra("Novascount");
        final String token = getIntent().getStringExtra("token");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Home = findViewById(R.id.Icon_Home_Home);
        Search = findViewById(R.id.Icon_Home_Search);
        Profile = findViewById(R.id.Icon_Home_Profile);
        Notifications = findViewById(R.id.Icon_Home_Notifs);
        PostTweet = findViewById(R.id.Icon_Home_PostTweet);
        TweetRecView = findViewById(R.id.RecyclerView_Home_Tweets);
         nav_photo_opener = findViewById(R.id.image_Home_Photo);
         drawer = findViewById(R.id.drawer_layout);
        NavigationView nav_view = findViewById(R.id.nav_view);

        String Name[] = {"Dina Walid", "Menna Walid", "Arwa Walid", "Ziad Walid"};
        String ScreenName[] = {"dinawalid", "mennawalid", "arwawalid", "ziadwalid"};
        String TweetText[] = {"Hi, I'm dina", "Hi, I'm menna", "Hi, I'm arwa", "Hi, I'm ziad"};
        String RetweetNumber[] = {"1", "2", "3", "4"};
        String RepliesNumber[] = {"1", "2", "3", "4"};
        String LikesNumber[] = {"1", "2", "3", "4"};
        for (int i = 0; i < Name.length; i++) {
            Tweets tweet = new Tweets(Name[i], ScreenName[i], TweetText[i], RetweetNumber[i], RepliesNumber[i], LikesNumber[i]);
            tweets.add(tweet);
        }
        TweetRecView.setLayoutManager(new LinearLayoutManager(HomePage.this));
        TweetsAdapter tweetsAdapter = new TweetsAdapter(tweets);
        TweetRecView.setAdapter(tweetsAdapter);

        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this, ProfilePage.class);
                i.putExtra("token", token);
                i.putExtra("name", name);
                i.putExtra("screenname", screenname);
                i.putExtra("verified", verified);
                i.putExtra("followersCount", followerscount);
                i.putExtra("favoritesCount", favoritesCount);
                i.putExtra("friendsCount", friendscout);
                i.putExtra("novasCount", novascount);
                i.putExtra("id", id);
                i.putExtra("email", email);
                startActivity(i);
                finish();

            }
        });
        Notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, NotificationsPage.class);
                startActivity(intent);
                finish();
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, Search.class);
                startActivity(intent);
                finish();
            }
        });
        PostTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostTweet alertDialog = new PostTweet();
                FragmentManager f = getSupportFragmentManager();
                alertDialog.show(f, "fragment_alert");
            }

        });

        nav_photo_opener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerOpen(Gravity.START)) {
                    drawer.closeDrawer(Gravity.START);
                } else {
                    drawer.openDrawer(Gravity.START);
                }
            }
        });
        nav_view.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_profile) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent i =new Intent(HomePage.this,ProfilePage.class);
            startActivity(i);
        } else if (id == R.id.nav_followers) {
            Intent i =new Intent(HomePage.this,Followers.class);
            startActivity(i);
        }
        else if (id == R.id.nav_following) {
            Intent i =new Intent(HomePage.this,Following.class);
            startActivity(i);
        }
        else if (id == R.id.nav_editprofile) {
            Intent i =new Intent(HomePage.this,EditProfile.class);
            startActivity(i);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
