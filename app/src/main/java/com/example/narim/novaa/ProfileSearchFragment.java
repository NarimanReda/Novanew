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
public class ProfileSearchFragment extends android.support.v4.app.Fragment {
    View view;
    RecyclerView RecylerView_Search_Profile;
    Context context;
    List<Profile> profiles=new ArrayList<>();


    public ProfileSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context=getActivity();
        view= inflater.inflate(R.layout.fragment_followers_notifications, container, false);
        String Name[]={"Dina Walid","Menna Walid", "Arwa Walid","Ziad Walid"};
        String ScreenName[] ={"dinaw","mennaw","arwaw","ziadw"};
        String Bio[] ={"Hi i'm dina","Hi i'm menna","Hi i'm arwa","Hi i'm ziad"};
        for(int i=0; i<Name.length; i++)
        {
            Profile profile =new Profile(Name[i],"@" + ScreenName[i],Bio[i]);
            profiles.add(profile);
        }
        RecylerView_Search_Profile=view.findViewById(R.id.FollowersNotifications_RecyclerView);
        RecylerView_Search_Profile.setLayoutManager(new LinearLayoutManager(context));
        ProfileSearchAdapter profiles_adapter=new ProfileSearchAdapter(profiles);
        RecylerView_Search_Profile.setAdapter(profiles_adapter);
        return view;
    }

}
