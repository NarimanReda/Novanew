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

public class Following extends AppCompatActivity {



    List<Following_Item> following=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following);

        RecyclerView Following_Recycle = findViewById(R.id.RecyclerView_Following);
       // setContentView(R.layout.activity_following);
        Following_Recycle.setLayoutManager(new LinearLayoutManager(this));
        Following_Adapter following_adapter=new Following_Adapter(following);
        Following_Recycle.setAdapter(following_adapter);

        TextView Back1 = findViewById(R.id.TextView_Following_Back);

        Back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Following.this,ProfilePage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
