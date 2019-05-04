package com.example.narim.novaa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MentionsNotificationsAdapter extends RecyclerView.Adapter<MentionsNotificationsAdapter.myViewHolder> {
    List<MentionsNotificationItem> Items;

    public MentionsNotificationsAdapter(List<MentionsNotificationItem> Items) {
        this.Items = Items;
    }

    /**
     * @param viewGroup
     * @param i
     * @return
     * Set each recycler view item to the given item layout
     */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View row= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mentionsnotificationitem,viewGroup,false);
        myViewHolder holder= new myViewHolder(row);
        return holder;
    }


    /**
     * @param myViewHolder
     * @param i
     *  Set the Mentions Notification data in the text views
     */
    @Override
    public void onBindViewHolder(@NonNull MentionsNotificationsAdapter.myViewHolder myViewHolder, int i) {
        MentionsNotificationItem item =Items.get(i);
        myViewHolder.UserWhoMentions.setText(item.UserWhoMentions);
        myViewHolder.TweetMentionedIn.setText(item.TweetMentionedIn);
    }

    /**
     * @return Count of given list
     */
    @Override
    public int getItemCount() {
        return Items.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView UserWhoMentions;
        TextView TweetMentionedIn;

        public myViewHolder(@NonNull final View itemView) {
            super(itemView);
            UserWhoMentions= itemView.findViewById(R.id.TextView_MentionNotifications_WhoMentionsName);
            TweetMentionedIn= itemView.findViewById(R.id.TextView_MentionNotifications_TweetMentionedIn);

        }
    }
}
