package com.example.narim.novaa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FollowersNotificationsAdapter extends RecyclerView.Adapter<FollowersNotificationsAdapter.myViewHolder> {
    List<FollowersNotificationItem> Items;

    public FollowersNotificationsAdapter(List<FollowersNotificationItem> Items) {
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
        View row= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.followersnotificationitem,viewGroup,false);
        myViewHolder holder= new myViewHolder(row);
        return holder;
    }


    /**
     * @param myViewHolder
     * @param i
     *  Set the Followers Notification data in the text views
     */
    @Override
    public void onBindViewHolder(@NonNull FollowersNotificationsAdapter.myViewHolder myViewHolder, int i) {
        FollowersNotificationItem item =Items.get(i);
        myViewHolder.FollowerName.setText(item.FollowerName);
             }

    /**
     * @return Count of given list
     */
    @Override
    public int getItemCount() {
        return Items.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView FollowerName;

        public myViewHolder(@NonNull final View itemView) {
            super(itemView);
            FollowerName= itemView.findViewById(R.id.TextView_FollowersNotifications_FollowerName);

        }
    }
}
