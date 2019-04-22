package com.example.narim.novaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
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
        getData();
        final TabLayout ProfilePage_TabLayout = findViewById(R.id.TabLayout_Profile);
        ViewPager ProfilePage_ViewPage = findViewById(R.id.ViewPager_Profile);
        TextView Back=findViewById(R.id.Textview_Profile_Back);

        ProfilePage_Adapter adapter = new ProfilePage_Adapter(getSupportFragmentManager());

        adapter.AddFragment("one", new profile_page_tweets());
        adapter.AddFragment("two", new profile_page_retweets());
        adapter.AddFragment("three", new profile_page_likes());
        adapter.AddFragment("four", new profile_page_media());

        ProfilePage_TabLayout.setupWithViewPager(ProfilePage_ViewPage);
        ProfilePage_ViewPage.setAdapter(adapter);
        ProfilePage_TabLayout.getTabAt(0).setCustomView(R.layout.tablayout_profile_page_tweets);
        ProfilePage_TabLayout.getTabAt(1).setCustomView(R.layout.tablayout_profile_page_retweets);
        ProfilePage_TabLayout.getTabAt(2).setCustomView(R.layout.tablayout_profile_page_likes);
        ProfilePage_TabLayout.getTabAt(3).setCustomView(R.layout.tablayout_profile_page_media);

        Button EditProfile = findViewById(R.id.Button_Profile_EditProfile);
        Button Following = findViewById(R.id.Button_Profile_Following);
        Button Followers = findViewById(R.id.Button_Profile_Followers);
        TextView SignOut=findViewById(R.id.Textview_Profile_SignOut);

        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProfilePage.this,SignIn.class);
                startActivity(intent);
                finish();
            }
        });
        EditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this,EditProfile.class);
                startActivity(intent);
                finish();
            }
        });

        Followers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this,Followers.class);
                startActivity(intent);
                finish();
            }
        });

        Following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this,Following.class);
                startActivity(intent);
                finish();
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ProfilePage.this,HomePage.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void getData(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://3.19.122.178:3000/statuses/user_timeline",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Gson gson = new Gson();
                            SignInResponse wrapper = gson.fromJson(response, SignInResponse.class);
                            SignInResult signInResult= wrapper.getUser();
                            Log.e("someOtherrrrr", response);
                            //Log.e("result",signInResult.getToken());
                           /*if (wrapper.getStatus()==200) {
                               SignInResult signInResult= wrapper.getResult();
                                Log.e("result",signInResult.getToken());
                            } else {
                                if(wrapper.getMessage()=="UserNotFound")
                                {
                                    Toast.makeText(SignIn.this,"User not found",Toast.LENGTH_LONG).show();
                                }
                                else if(wrapper.getMessage()=="IncorrectPassword")
                                {
                                    Toast.makeText(SignIn.this,"IncorrectPassword", Toast.LENGTH_LONG).show();
                                }
                           }*/
                        } catch (Exception e) {
                            //commonCallBackInterface.onSuccess("ServicePl_VolleyError", "VolleyError");
                            //e.printStackTrace();
                            Log.e("someOther", response);

                            //   Log.e("name",wrapper.UserObject.getName());

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // commonCallBackInterface.onSuccess("ServicePl_VolleyError", "VolleyError");
                    }
                }) {

            @Override
            public byte[] getBody() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("token",getIntent().getStringExtra("token"));
                return new JSONObject(params).toString().getBytes();
            }
            @Override
            public String getBodyContentType() {
                return "application/json";
            }
            //---------------------------
        };

        stringRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 20 * 1000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 20 * 1000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {
                error.printStackTrace();
                //commonCallBackInterface.onSuccess("ServicePl_VolleyError", "VolleyError");
            }
        });

        VolleySingelton volleySingleton = VolleySingelton.getInstance(this);
        volleySingleton.getRequestQueue().add(stringRequest);

    }
}
