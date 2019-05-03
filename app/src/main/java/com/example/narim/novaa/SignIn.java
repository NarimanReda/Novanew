package com.example.narim.novaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class SignIn extends AppCompatActivity {

    Button SignIn,SignUp,ForgotPassword;
    EditText SignInField,PasswordField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        SignInField = findViewById(R.id.EditText_SignIn_Email);
        PasswordField = findViewById(R.id.EditText_SignIn_Password);
        SignIn = findViewById(R.id.Button_SignIn_Confirm);
        SignUp = findViewById(R.id.Button_SignIn_SignUp);
        ForgotPassword = findViewById(R.id.Button_SignIn_ForgotPassword);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(SignInField.getText().toString().equals("") && PasswordField.getText().toString().equals(""))
                    Toast.makeText(SignIn.this, "Please Enter Email and Password",Toast.LENGTH_SHORT).show();
                else if(SignInField.getText().toString().equals(""))
                    Toast.makeText(SignIn.this, "Please Enter Your Email",Toast.LENGTH_SHORT).show();
                else if( !CheckEmail(SignInField.getText().toString()))
                    Toast.makeText(SignIn.this, "Please Enter Valid Email",Toast.LENGTH_SHORT).show();
                else if( PasswordField.getText().toString().equals(""))
                    Toast.makeText(SignIn.this, "Please Enter Your Password",Toast.LENGTH_SHORT).show();
                //else if( PasswordField.getText().length()>25 || PasswordField.getText().length() < 8  )
                    //Toast.makeText(SignIn.this, "Please Enter Valid Password",Toast.LENGTH_SHORT).show();
                else {
                    getData();
                }
            }
        }); SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this,SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this,ForgotPassword.class);
                startActivity(intent);
                finish();
            }
        });

    }

    /**
     * @param Email
     * @return True if email is valid
     * False if email is invalid
     */
    public boolean CheckEmail(String Email) {

        String ePattern = "^[a-zA-Z]+[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]*@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(Email);
        return m.matches();
    }


    /**
     * Connects to the url , sends reuests and gets response
     */
    private void getData(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://3.19.122.178:3000/accounts/signin",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null) {
                            Gson gson = new Gson();
                            Log.e("res", response);
                            JSONObject reader = null;
                            String token="";
                            String created_at="";
                            String location="";
                            String bio="";
                            String profileimageurl="";
                            String id="";
                            String name="";
                            String email="";
                            String password="";
                            String screenname="";
                            String notifId="";
                            int followerscount=0;
                            int friendscount=0;
                            int favoritescount=0;
                            int novascount=0;
                            int __v=0;
                            boolean verified=true;
                            boolean default_profile_image=true;
                            String[]NovasIDS=new String[0];
                            String[] NovasList=new String[0];
                            String[] favoriteIds=new String[0];
                            String[] FavoritesList=new String[0];
                            String[] MentionsList=new String[0];
                            try {
                                reader = new JSONObject(response.toString());
                                token = reader.getString("token");
                                JSONObject user=reader.getJSONObject("user");
                                 verified=user.getBoolean("verified");
                                 location=user.getString("location");
                                 bio=user.getString("bio");
                                 followerscount=user.getInt("followers_Count");
                                 friendscount=user.getInt("friends_count");
                                 favoritescount=user.getInt("favorites_count");
                                 novascount=user.getInt("novas_count");
                                JSONArray novasIDs= user.getJSONArray("novas_IDs");
                                NovasIDS=new String[novasIDs.length()];
                                for(int i=0;i<novasIDs.length();i++)
                                {
                                    NovasIDS[i]=novasIDs.getString(i);
                                }
                                JSONArray favoritenovasIDs=user.getJSONArray("favorites_novas_IDs");
                                favoriteIds=new String[favoritenovasIDs.length()];
                                for(int i=0;i<favoritenovasIDs.length();i++)
                                {
                                    favoriteIds[i]=favoritenovasIDs.getString(i);
                                }
                                 profileimageurl=user.getString("profile_image_url");
                                 default_profile_image=user.getBoolean("default_profile_image");
                                 id=user.getString("_id");
                                 name=user.getString("name");
                                 email=user.getString("email");
                                 password=user.getString("password");
                                 screenname=user.getString("screen_name");
                                 created_at=user.getString("created_at");
                                __v=user.getInt("__v");
                                JSONObject NotifObject=user.getJSONObject("notification_object");
                                 notifId=NotifObject.getString("_id");
                                JSONArray novasList=NotifObject.getJSONArray("renova_list");
                                NovasList=new String[novasList.length()];
                                for(int i=0;i<novasList.length();i++)
                                {
                                    NovasList[i]=novasList.getString(i);
                                }
                                JSONArray favoritesList=NotifObject.getJSONArray("favorite_list");
                                FavoritesList=new String[favoritesList.length()];
                                for(int i=0;i<favoritesList.length();i++)
                                {
                                    FavoritesList[i]=favoritesList.getString(i);
                                }
                                JSONArray mention_list =NotifObject.getJSONArray("mention_list");
                                MentionsList=new String[mention_list.length()];
                                for(int i=0;i<mention_list.length();i++)
                                {
                                    MentionsList[i]=mention_list.getString(i);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Intent i = new Intent(SignIn.this, Profile.class);
                            i.putExtra("token",token);
                            i.putExtra("verified",verified);
                            i.putExtra("location",location);
                            i.putExtra("bio",bio);
                            i.putExtra("followerscount",followerscount);
                            i.putExtra("friendscount",friendscount);
                            i.putExtra("favoritescount",favoritescount);
                            i.putExtra("novascount",novascount);
                            i.putExtra("novasids",NovasIDS);
                            i.putExtra("favoriteIDs",favoriteIds);
                            i.putExtra("profileimageurl",profileimageurl);
                            i.putExtra("defaultprofileimage",default_profile_image);
                            i.putExtra("id",id);
                            i.putExtra("name",name);
                            i.putExtra("email",email);
                            i.putExtra("password",password);
                            i.putExtra("screenname",screenname);
                            i.putExtra("createdat",created_at);
                            i.putExtra("__v",__v);
                            i.putExtra("NotifID",notifId);
                            i.putExtra("NovasList",NovasList);
                            i.putExtra("FavoritesList",FavoritesList);
                            i.putExtra("MentionsList",MentionsList);
                            startActivity(i);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        NetworkResponse networkResponse = error.networkResponse;
                        if (networkResponse != null && networkResponse.data != null) {
                            String jsonError = new String(networkResponse.data);
                            JSONObject JO = null;
                            try {
                                JO = new JSONObject(jsonError);
                                String msg= JO.getString("msg");
                                Toast.makeText(SignIn.this,msg,Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Log.e("errormessage",jsonError);

                        }
                    }
                }) {

            @Override
            public byte[] getBody() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("email",SignInField.getText().toString() );
                params.put("password",PasswordField.getText().toString());
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
            }
        });

        VolleySingelton volleySingleton = VolleySingelton.getInstance(this);
        volleySingleton.getRequestQueue().add(stringRequest);

    }
}