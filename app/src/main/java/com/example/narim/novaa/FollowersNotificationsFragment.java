package com.example.narim.novaa;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

public class FollowersNotificationsFragment extends android.support.v4.app.Fragment {
    View view;
    RecyclerView FollowerNotifications_recylerview;
    Context context;
    List<FollowersNotificationItem> followers=new ArrayList<>();


    public FollowersNotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context=getActivity();
        view= inflater.inflate(R.layout.fragment_followers_notifications, container, false);
        String Name[]={"Dina Walid","Menna Walid", "Arwa Walid","Ziad Walid"};
        for(int i=0; i<Name.length; i++)
        {
            FollowersNotificationItem follower =new FollowersNotificationItem(Name[i]);
            followers.add(follower);
        }
        FollowerNotifications_recylerview=view.findViewById(R.id.FollowersNotifications_RecyclerView);
        FollowerNotifications_recylerview.setLayoutManager(new LinearLayoutManager(context));
        FollowersNotificationsAdapter followers_adapter=new FollowersNotificationsAdapter(followers);
        FollowerNotifications_recylerview.setAdapter(followers_adapter);
        return view;

    }

}
