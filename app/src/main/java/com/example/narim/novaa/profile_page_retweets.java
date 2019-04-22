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
public class profile_page_retweets extends android.support.v4.app.Fragment {

    RecyclerView TweetRecView;
    List<Tweets> tweets= new ArrayList<>();
    Context context;
    View view;
    public profile_page_retweets() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile_page_retweets, container, false);
        context=getActivity();
        TweetRecView=view.findViewById(R.id.RecyclerView_ProfileRetweets);
        String Name[]={"Dina Walid","Menna Walid", "Arwa Walid","Ziad Walid"};
        String ScreenName[]={"dinawalid","mennawalid","arwawalid","ziadwalid"};
        String TweetText[]={"Hi, I'm dina","Hi, I'm menna","Hi, I'm arwa","Hi, I'm ziad"};
        String RetweetNumber[]={"1","2","3","4"};
        String RepliesNumber[]={"1","2","3","4"};
        String LikesNumber[]={"1","2","3","4"};
        for(int i=0; i<Name.length; i++)
        {
            Tweets tweet =new Tweets(Name[i],ScreenName[i],TweetText[i],RetweetNumber[i],RepliesNumber[i],LikesNumber[i]);
            tweets.add(tweet);
        }
        TweetRecView.setLayoutManager(new LinearLayoutManager(context));
        ProfileRetweetsAdapter tweetsAdapter=new ProfileRetweetsAdapter(tweets);
        TweetRecView.setAdapter(tweetsAdapter);
        return view;
    }

}
