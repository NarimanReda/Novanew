package com.example.narim.novaa;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class PostTweet extends DialogFragment {
View view;
Context context;
Button tweet;
TextView cancel;
EditText tweettext;

    public PostTweet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.posttweet, container, false);
        tweet=view.findViewById(R.id.textview_posttweet_tweet);
        tweettext=view.findViewById(R.id.EditText_Posttweet);
        cancel=view.findViewById(R.id.textview_posttweet_cancel);
        context=getActivity();
        tweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tweettext.getText().toString().isEmpty())
                    Toast.makeText(context,"Your Nova is empty!", Toast.LENGTH_LONG).show();
                else
                    getData();
                    dismiss();


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return view;
    }

    /**
     * @param title
     * @return
     */
    public static PostTweet newInstance(String title) {
        PostTweet frag = new PostTweet();
        return frag;
    }
    private void getData(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://3.19.122.178:3000/statuses/update",
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
                params.put("text",tweettext.getText().toString());
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

        VolleySingelton volleySingleton = VolleySingelton.getInstance(context);
        volleySingleton.getRequestQueue().add(stringRequest);

    }

}
