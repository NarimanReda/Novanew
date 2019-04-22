package com.example.narim.novaa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ProfileLikesAdapter extends RecyclerView.Adapter<ProfileLikesAdapter.myViewHolder>{
    List<Tweets> Tweets;
    public ProfileLikesAdapter(List<Tweets> tweets)
    {this.Tweets= tweets;}

    /**
     * @param viewGroup
     * @param i
     * @return
     * Set each recycler view item to the given item layout
     */
    @NonNull
    @Override
    public ProfileLikesAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View row= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tweets_item,viewGroup,false);
        myViewHolder holder= new ProfileLikesAdapter.myViewHolder(row);
        return holder;
    }

    /**
     * @param myViewHolder
     * @param i
     * Set the liked tweets data in the text views
     */
    @Override
    public void onBindViewHolder(@NonNull ProfileLikesAdapter.myViewHolder myViewHolder, int i) {
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
     * This methods return the count of the given liked tweets list
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
