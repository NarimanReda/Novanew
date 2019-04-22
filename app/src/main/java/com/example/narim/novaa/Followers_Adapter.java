package com.example.narim.novaa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Followers_Adapter extends RecyclerView.Adapter<Followers_Adapter.myViewHolder> {
    List<Followers_Item> Items;

    public Followers_Adapter(List<Followers_Item> Items) {
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
        View row= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_followers_following,viewGroup,false);
        myViewHolder holder= new myViewHolder(row);
        return holder;
    }


    /**
     * @param myViewHolder
     * @param i
     * Set the followers data in the text views
     */
    @Override
    public void onBindViewHolder(@NonNull Followers_Adapter.myViewHolder myViewHolder, int i) {
        Followers_Item item =Items.get(i);
        myViewHolder.Name.setText(item.Name);
        myViewHolder.Username.setText(item.Username);
    }

    /**
     * @return
     * This methods return the count of the given Followers list
     */
    @Override
    public int getItemCount() {
        return Items.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView Name;
        TextView Username;

        public myViewHolder(@NonNull final View itemView) {
            super(itemView);
            Name= itemView.findViewById(R.id.TextView_Following_Followers_Name);
            Username= itemView.findViewById(R.id.TextView_Following_Followers_Username);
        }
    }
}