package com.example.narim.novaa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProfileSearchAdapter extends RecyclerView.Adapter<ProfileSearchAdapter.myViewHolder> {
    List<Profile> Items;

    public ProfileSearchAdapter(List<Profile> Items) {
        this.Items = Items;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View row= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_item,viewGroup,false);
        myViewHolder holder= new myViewHolder(row);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ProfileSearchAdapter.myViewHolder myViewHolder, int i) {
        Profile item =Items.get(i);
        myViewHolder.ProfileName.setText(item.ProfileName);
        myViewHolder.ScreenName.setText(item.ProfileScreenName);
        myViewHolder.Bio.setText(item.Bio);
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView ProfileName;
        TextView ScreenName;
        TextView Bio;

        public myViewHolder(@NonNull final View itemView) {
            super(itemView);
            ProfileName= itemView.findViewById(R.id.TextView_Profile_Name);
            ScreenName= itemView.findViewById(R.id.TextView_Profile_ScreenName);
            Bio= itemView.findViewById(R.id.TextView_Profile_Bio);

        }
    }
}
