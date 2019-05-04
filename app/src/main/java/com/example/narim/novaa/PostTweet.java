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
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
                else {
                    getData();

                }
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
                            Log.e("Response:", response);
                        } catch (Exception e) {

                        }
                        dismiss();
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
                                String msg = JO.getString("msg");
                                //  Toast.makeText(SignUp.this, msg, Toast.LENGTH_LONG).show();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            dismiss();
                            Log.e("errormessage", jsonError);
                        }







                    }
                }) {

            @Override
            public byte[] getBody() throws AuthFailureError
            {
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("text","dinadina");
                // params.put("in_reply_to status_id",null);
                //params.put("media_ids",null);
                return new JSONObject(params).toString().getBytes();
            }
            @Override
            public String getBodyContentType() {
                return "application/json";
            }
            //---------------------------
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                //map.put("X-Device-Info","Android FOO BAR");

                map.put("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1Y2JhMDA5MzliOGIxNDIwMTA4Njc3MDUiLCJzY3JlZW5fbmFtZSI6ImhhbWFkYSIsImlhdCI6MTU1Njk1OTI4Mn0.Whd3erzia_SjRmIcter2skWgvLED_sZx4SyL2hNmHjA");
                //map.put("Content-Type", "application/json; charset=UTF-8");

                return map;
            }
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
