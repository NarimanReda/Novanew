package com.example.narim.novaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class EditProfile extends AppCompatActivity {
    EditText Name, Username, Bio, Location;
    Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        TextView Cancel = findViewById(R.id.Textview_EditProfile_Cancel);
        Save = findViewById(R.id.Button_EditProfile_Save);
        Name = findViewById(R.id.EditText_EditProfile_Name);
        Username = findViewById(R.id.EditText_EditProfile_UserName);
        Bio = findViewById(R.id.EditText_EditProfile_Bio);
        Location = findViewById(R.id.EditText_EditProfile_Loc);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfile.this, ProfilePage.class);
                startActivity(intent);
                finish();
            }
        });

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfile.this, ProfilePage.class);
                getData();
                startActivity(intent);
                finish();
            }
        });

        Name.addTextChangedListener(EditProfile);
        Username.addTextChangedListener(EditProfile);
        Bio.addTextChangedListener(EditProfile);
        Location.addTextChangedListener(EditProfile);
    }

    private TextWatcher EditProfile = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (!(Name.getText().toString().isEmpty()) || !(Username.getText().toString().isEmpty()) || !(Bio.getText().toString().isEmpty()) || !(Location.getText().toString().isEmpty())) {
                Save.setVisibility(View.VISIBLE);
            }
            if ((Name.getText().toString().isEmpty()) && (Username.getText().toString().isEmpty()) && (Bio.getText().toString().isEmpty()) && (Location.getText().toString().isEmpty())) {
                Save.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {


        }
    };

    private void getData(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://3.19.122.178:8080/accounts/settings",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Gson gson = new Gson();
                            EditProfileResult wrapper = gson.fromJson(response, EditProfileResult.class);
                            Intent intent=new Intent(com.example.narim.novaa.EditProfile.this, ProfilePage.class);
                            intent.putExtra("id",wrapper.get_id());
                            intent.putExtra("screenname",wrapper.getScreen_name());
                            intent.putExtra("name",wrapper.getName());
                            intent.putExtra("bio",wrapper.getBio());
                            intent.putExtra("location",wrapper.getLocation());
                            startActivity(intent);
                        } catch (Exception e) {
                            //commonCallBackInterface.onSuccess("ServicePl_VolleyError", "VolleyError");
                            //e.printStackTrace();
                            //Gson gson = new Gson();
                            // SignInResponse wrapper = gson.fromJson(response, SignInResponse.class);
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
                params.put("screen_name",Name.getText().toString() );
                params.put("name",Username.getText().toString());
                 params.put("location",Location.getText().toString());
                  params.put("bio",Bio.getText().toString());
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
