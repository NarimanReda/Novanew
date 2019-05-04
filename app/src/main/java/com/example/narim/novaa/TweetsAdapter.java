package com.example.narim.novaa;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.myViewHolder>{
    List<Tweets> Tweets;
    Context context;
    public TweetsAdapter(Context context)
    {this.context=context;}
    SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(context);
    String response = m.getString(" response", " response");
    JSONObject reader;
    {
        try {
            reader = new JSONObject(response.toString());
            JSONArray array=reader.getJSONArray("");
            Tweets=new ArrayList<>(array.length());
            for(int i=0; i<array.length(); i++){
                JSONObject c = array.getJSONObject(i);
                Tweets.get(i).ProfileName=c.getString("in_reply_to_screen_name");
                Tweets.get(i).ProfileScreenName=c.getString("in_reply_to_screen_name");
                Tweets.get(i).TweetText=c.getString("text");
                Tweets.get(i).RetweetsNumber=String.valueOf(c.getInt("renova_count"));
                Tweets.get(i).LikesNumber=String.valueOf(c.getInt("favorite_count"));
                Tweets.get(i).RepliesNumber=String.valueOf(c.getInt("reply_count"));
                Tweets.get(i).Renovad=c.getBoolean("renovaed");
                 /*
                 in_reply_to_status_id= c.getString("in_reply_to_status_id");
                in_reply_to_user_id=c.getString("in_reply_to_user_id");
                in_reply_to_screen_name=c.getString("in_reply_to_screen_name");
                user=c.getString("user");
                reply_count=c.getInt("reply_count");
                renova_count=c.getInt("renova_count");
                favorite_count=c.getInt("favorite_count");
                renovaed=c.getBoolean("renovaed");
                _id=c.getString("_id");
                text=c.getString("text");
                created_at=c.getString("created_at");
                user_name=c.getString("user_name");
                user_screen_name=c.getString("user_screen_name");*/
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    /**
     * @param viewGroup
     * @param i
     * Set each recycler view item to the given item layout
     * @return
     */
    @NonNull
    @Override
    public TweetsAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View row= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tweets_item,viewGroup,false);
        myViewHolder holder= new TweetsAdapter.myViewHolder(row);
        return holder;
    }

    /**
     * @param myViewHolder
     * @param i
     * Set the Tweets data in the text views
     */
    @Override
    public void onBindViewHolder(@NonNull TweetsAdapter.myViewHolder myViewHolder, int i) {
        Tweets tweets= Tweets.get(i);
            myViewHolder.ProfileName.setText(tweets.ProfileName);
            myViewHolder.ProfileScreenName.setText(tweets.ProfileScreenName);
            myViewHolder.TweetText.setText(tweets.TweetText);
            myViewHolder.RetweetsNumber.setText(tweets.RetweetsNumber);
            myViewHolder.RepliesNumber.setText(tweets.RepliesNumber);
            myViewHolder.LikesNumber.setText(tweets.LikesNumber);
    }

    /**
     * @return
     * This methods return the count of the given Tweets list
     */
    @Override
    public int getItemCount() {
        return Tweets.size();
    }


    class myViewHolder extends RecyclerView.ViewHolder {
        TextView ProfileName;
        TextView ProfileScreenName;
        TextView TweetText;
        TextView RepliesNumber;
        TextView RetweetsNumber;
        TextView LikesNumber;


        public myViewHolder(@NonNull final View itemView) {
            super(itemView);
            ProfileName=itemView.findViewById(R.id.Tweet_Name);
            ProfileScreenName= itemView.findViewById(R.id.Tweet_ScreenName);
            TweetText= itemView.findViewById(R.id.Tweet_TweetText);
            RepliesNumber=itemView.findViewById(R.id.Tweet_RepliesNumber);
            RetweetsNumber=itemView.findViewById(R.id.Tweet_RetweetsNumber);
            LikesNumber=itemView.findViewById(R.id.Tweet_LikesNumber);
        }

    }
}
