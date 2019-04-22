package com.example.narim.novaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Followers extends AppCompatActivity {

    List<Followers_Item> followers=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        RecyclerView Followers_Recycle = findViewById(R.id.RecyclerView_Followers);
        Followers_Recycle.setLayoutManager(new LinearLayoutManager(this));
        Followers_Adapter followers_adapter=new Followers_Adapter(followers);
        Followers_Recycle.setAdapter(followers_adapter);

        TextView Back = findViewById(R.id.TextView_Followers_Back);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Followers.this,ProfilePage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
