package com.example.narim.novaa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class SignUp extends AppCompatActivity {

    TextView InvalidName;
    TextView InvalidScreenName;
    TextView InvalidEmail;
    TextView NotTheSamePassword;
    TextView text1;
    EditText Name,ScreenName,Email,Password,RePassword;

    /**
     * @param Email
     * @return True if email is valid
     * False if email is invalid
     */
    public boolean CheckEmail(String Email) {

        if(Email.isEmpty())
            return false;
        String ePattern = "^[a-zA-Z]+[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]*@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(Email);
        return m.matches();
    }

    /**
     * @param ScreenName
     * @return True if screen name is not empty and it is within range
     * False if screen name is empty or not valid
     */
    public boolean CheckScreenName(String ScreenName) {
        if (ScreenName.isEmpty()) {
            return false;
        }
        if (ScreenName.length() >= 15)
            return false;

        if (ScreenName.contains(" "))
            return false;

        char[] CheckScreenName = ScreenName.toCharArray();
        if (!Character.isLetter(CheckScreenName[0])) {
            return false;
        }
        return true;

    }

    /**
     * @param Name
     * @return True if screen name is not empty and it is within range
     * False if screen name is empty or not valid
     */
    public boolean CheckName(String Name){
        if(Name.length() >= 15 )
            return false;

        int SpaceCount = 0;
        char[] CheckName = Name.toCharArray();
        for( int i = 0;i<CheckName.length;i++) {
            if (Character.isWhitespace(CheckName[i]))
                SpaceCount++;
        }
        if(SpaceCount == Name.length())
            return false;

        return true;
    }

    /**
     * @param p1
     * @param p2
     * @return True if two passwords match and are withing range
     * False if two passwords don't match or are invalid
     */
    public boolean CheckPassword(String p1, String p2) {

        if (p1.length() != p2.length()) {
            return false;
        }else if(p1.isEmpty() || p2.isEmpty()){
            return false;
        }
        else {

            char[] p1char = p1.toCharArray();
            char[] p2char = p2.toCharArray();
            for (int i = 0; i < p1.length(); i++) {
                if (p1char[i] != p2char[i]) {
                    return false;
                }
            }
            return true;
        }
    }


    /**
     * @return True if all data is filled and valid
     * False if any data is missing or invalid
     */
    public boolean check() {


        String Warning = null;
        boolean Check = true;
        InvalidName.setVisibility(View.INVISIBLE);
        InvalidScreenName.setVisibility(View.INVISIBLE);
        InvalidEmail.setVisibility(View.INVISIBLE);
        NotTheSamePassword.setVisibility(View.INVISIBLE);

        if (Name.getText().toString().isEmpty() || ScreenName.getText().toString().isEmpty() || Email.getText().toString().isEmpty() || Password.getText().toString().isEmpty()) {
            Warning = "Please enter your missing data ";
        } else if (Name.getText().toString().isEmpty()) {
            Warning = "Please enter your Name";
        } else if (ScreenName.getText().toString().isEmpty()) {
            Warning = "Please enter your screen Name";
        } else if (Email.getText().toString().isEmpty()) {
            Warning = "Please enter your Email";
        } else if (Password.getText().toString().isEmpty()) {
            Warning = "Please enter your Password";
        } else if ((Password.length() < 8 || Password.length() > 25 || RePassword.length() < 8 || RePassword.length() > 25))
            Warning = "Please enter valid Password";



        if(Warning!=null) {
            Toast.makeText(this, Warning, Toast.LENGTH_LONG).show();
            Check = false;
        }
        if(Name.getText().length()>15 || !CheckName(Name.getText().toString())){
            InvalidName.setVisibility(View.VISIBLE);
            Check = false;
        }
        if(ScreenName.getText().length()>15 || !CheckScreenName(ScreenName.getText().toString())){
            InvalidScreenName.setVisibility(View.VISIBLE);
            Check = false;
        }
        if(!CheckEmail(Email.getText().toString())&& Email.length()==0){
            InvalidEmail.setVisibility(View.VISIBLE);
            Check = false;
        }
        if(!CheckPassword(Password.getText().toString(),RePassword.getText().toString())){
            NotTheSamePassword.setVisibility(View.VISIBLE);
            Check = false;

        }

        if(Check){
            return true;
        } else {
            return false;
        }
    }


    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        text1= findViewById(R.id.Text1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Name =(EditText) findViewById(R.id.EditText_SignUp_Name);
        ScreenName =(EditText) findViewById(R.id.EditText_SignUp_ScreenName);
        Email =(EditText) findViewById(R.id.EditText_SignUp_Email);
        Password =(EditText) findViewById(R.id.EditText_SignUp_Password);
        RePassword = (EditText) findViewById(R.id.EditText_SignUp_ReEnterPassword);
        InvalidName =(TextView) findViewById(R.id.TextView_SignUp_InvalidName);
        InvalidScreenName=(TextView) findViewById(R.id.TextView_SignUp_InvalidScreenName);
        InvalidEmail=(TextView) findViewById(R.id.TextView_SignUp_InvalidEmail);
        NotTheSamePassword=(TextView) findViewById(R.id.TextView_SignUp_InvalidPassword);

        InvalidName.setVisibility(View.INVISIBLE);
        InvalidScreenName.setVisibility(View.INVISIBLE);
        InvalidEmail.setVisibility(View.INVISIBLE);
        NotTheSamePassword.setVisibility(View.INVISIBLE);
        Button SignIn = findViewById(R.id.Button_SignUp_SignInButton);
        Button Confirm= findViewById(R.id.Button_SignUp_ConfirmButton);
        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              boolean check = check();
              if (check==true)
              {
                    getData();
                  Intent intent = new Intent(SignUp.this,HomePage.class);
              }

            }
        });
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this,SignIn.class);
                startActivity(intent);
                finish();
            }

        });

    }

    private void sharedResponse(String key,String value) {
        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = m.edit();
        editor.putString(key, value);
        editor.commit();
    }
    /**
     * Connects to the url , sends reuests and gets response
     */
    private void getData(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://3.19.122.178:8080/accounts/signup",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null) {
                           // Gson gson = new Gson();
                            Log.e("res", response);
                            JSONObject reader = null;
                            try {
                                reader = new JSONObject(response.toString());
                                JSONObject user = reader.getJSONObject("user");
                                String name = user.getString("name");
                                sharedResponse("signupname",name);
                                if(name!=null)
                                {
                                    Toast.makeText(SignUp.this,"Check email for verification then Sign In",Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            /*Intent i = new Intent(SignUp.this, HomePage.class);
                            i.putExtra("token",wrapper.getToken());
                            i.putExtra("name",signUpResult.getName());
                            i.putExtra("screenname",signUpResult.getScreen_name());
                            i.putExtra("verified",signUpResult.getVerified());
                            i.putExtra("followersCount",signUpResult.getFollowers_count());
                            i.putExtra("favoritesCount",signUpResult.getFavorites_count());
                            i.putExtra("friendsCount",signUpResult.getFriends_count());
                            i.putExtra("novasCount",signUpResult.getNovas_count());
                            i.putExtra("id",signUpResult.get_id());
                            i.putExtra("email",signUpResult.getEmail());
                            startActivity(i);*/
                            //Log.e("email",signUpResult.getEmail());
                            //Log.e("screenname",signUpResult.getScreen_name());

                            // Log.e("name",signUpResult.getName());
                            //} catch (Exception e) {
                            //commonCallBackInterface.onSuccess("ServicePl_VolleyError", "VolleyError");
                            //  e.printStackTrace();
                            //}
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
                                    Toast.makeText(SignUp.this,msg,Toast.LENGTH_LONG).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Log.e("errormessage",jsonError);

                        }
                    }
                })


        {


            @Override
            public byte[] getBody() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("name",Name.getText().toString());
                params.put("screen_name",ScreenName.getText().toString());
                params.put("email",Email.getText().toString() );
                params.put("password",Password.getText().toString());
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