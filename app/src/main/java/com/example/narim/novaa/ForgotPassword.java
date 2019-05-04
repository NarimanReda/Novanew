package com.example.narim.novaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class ForgotPassword extends AppCompatActivity {

    EditText Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        TextView Back = findViewById(R.id.Image_ForgotPassword_Back);
        Button Confirm = findViewById(R.id.Button_ForgotPassword_Confirm);
        Email = findViewById(R.id.EditText_ForgotPassword_Email);
        final EditText SignInField = findViewById(R.id.EditText_ForgotPassword_Email);


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPassword.this,SignIn.class);
                startActivity(intent);
                finish();
            }

        });

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(SignInField.getText().toString().equals(""))
                    Toast.makeText(ForgotPassword.this, "Please Enter Your Email",Toast.LENGTH_SHORT).show();
                if( !CheckEmail(SignInField.getText().toString()))
                    Toast.makeText(ForgotPassword.this, "Please Enter Valid Email",Toast.LENGTH_SHORT).show();
                else
                {
                    getData();
                    Intent i=new Intent(ForgotPassword.this,HomePage.class);
                    startActivity(i);
                    finish();
                }
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
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://3.19.122.178:8080/forgotpassword1",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Gson gson = new Gson();
                            ForgotPasswordResult wrapper = gson.fromJson(response, ForgotPasswordResult.class);
                            Log.e("someOtherrrrr", response);

                                Toast.makeText(ForgotPassword.this,wrapper.getMsg(),Toast.LENGTH_LONG).show();

                        } catch (Exception e) {
                            //commonCallBackInterface.onSuccess("ServicePl_VolleyError", "VolleyError");
                            e.printStackTrace();
                            Log.e("someOther", response);
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
                params.put("email",Email.getText().toString() );
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