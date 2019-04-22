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
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

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
                Intent intent = new Intent(SignIn.this,HomePage.class);
                 startActivity(intent);
                 finish();}
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

                        try {
                            Gson gson = new Gson();
                            SignInResponse wrapper = gson.fromJson(response, SignInResponse.class);
                            SignInResult signInResult= wrapper.getUser();
                           Log.e("someOtherrrrr", response);
                            Intent i = new Intent(SignIn.this, HomePage.class);
                            i.putExtra("token",wrapper.getToken());
                            i.putExtra("name",signInResult.getName());
                            i.putExtra("screenname",signInResult.getScreen_name());
                            i.putExtra("verified",signInResult.getVerified());
                            i.putExtra("followersCount",signInResult.getFollowers_count());
                            i.putExtra("favoritesCount",signInResult.getFavorites_count());
                            i.putExtra("friendsCount",signInResult.getFriends_count());
                            i.putExtra("novasCount",signInResult.getNovas_count());
                            i.putExtra("id",signInResult.get_id());
                            i.putExtra("email",signInResult.getEmail());
                            startActivity(i);
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
                //commonCallBackInterface.onSuccess("ServicePl_VolleyError", "VolleyError");
            }
        });

        VolleySingelton volleySingleton = VolleySingelton.getInstance(this);
        volleySingleton.getRequestQueue().add(stringRequest);

    }
}