package com.example.narim.novaa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        int seconds = 1;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation= AnimationUtils.loadAnimation(Splash.this,R.anim.slide_up);
                LinearLayout welc_page=findViewById(R.id.layout_SignInSignUp);
                welc_page.startAnimation(animation);
                welc_page.setVisibility(View.VISIBLE);

            }

        }, seconds * 1000);

        final Button SignIn=findViewById(R.id.button_splash_signIn);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Splash.this,SignIn.class);
                startActivity(intent);
                finish();
            }
        });

        final Button SignUp=findViewById(R.id.button_splash_signUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(Splash.this,SignUp.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
