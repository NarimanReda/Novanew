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
public class MentionsNotificationsFragment extends android.support.v4.app.Fragment {

    View view;
    RecyclerView MentionsNotifications_recylerview;
    Context context;
    List<MentionsNotificationItem> mentions=new ArrayList<>();

    public MentionsNotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context=getActivity();
        view= inflater.inflate(R.layout.fragment_mentions_notifications, container, false);
        String WhoMentionsName[]={"Dina Walid","Menna Walid", "Arwa Walid","Ziad Walid"};
        String tweetsMentionedIn[] = {" heyy dude", " Ana mennaa " , " Ana arwa ezayak " , " Ana akhohom"};
        for(int i=0; i<WhoMentionsName.length; i++)
        {
            MentionsNotificationItem mention =new MentionsNotificationItem(WhoMentionsName[i],tweetsMentionedIn[i]);
            mentions.add(mention);
        }
        MentionsNotifications_recylerview=view.findViewById(R.id.MentionsNotifications_RecyclerView);
        MentionsNotifications_recylerview.setLayoutManager(new LinearLayoutManager(context));
        MentionsNotificationsAdapter mentions_adapter=new MentionsNotificationsAdapter(mentions);
        MentionsNotifications_recylerview.setAdapter(mentions_adapter);
        return view;

    }

}
