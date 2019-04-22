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
public class TweetsSearchFragment extends android.support.v4.app.Fragment{
    View view;
    RecyclerView RecylerView_Search_Tweets;
    Context context;
    List<Tweets> tweets=new ArrayList<>();


    public TweetsSearchFragment() {
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
        String TweetText[] ={"Hi i'm dina","Hi i'm menna","Hi i'm arwa","Hi i'm ziad"};
        String RepliesNumber[] ={"5","3","2","5"};
        String RetweetsNumber[] ={"1","1","1","1"};
        String LikesNumber[] ={"4","9","0","100"};

        for(int i=0; i<Name.length; i++)
        {
            Tweets tweet =new Tweets(Name[i],ScreenName[i],TweetText[i],RepliesNumber[i],RetweetsNumber[i],LikesNumber[i]);
            tweets.add(tweet);
        }
        RecylerView_Search_Tweets=view.findViewById(R.id.FollowersNotifications_RecyclerView);
        RecylerView_Search_Tweets.setLayoutManager(new LinearLayoutManager(context));
        TweetsAdapter tweets_adapter=new TweetsAdapter(tweets);
        RecylerView_Search_Tweets.setAdapter(tweets_adapter);
        return view;
    }

}
