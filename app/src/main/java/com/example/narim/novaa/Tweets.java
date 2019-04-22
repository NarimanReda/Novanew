package com.example.narim.novaa;

public class Tweets {
    String ProfileName;
    String ProfileScreenName;
    String TweetText;
    String RepliesNumber;
    String RetweetsNumber;
    String LikesNumber;

    public Tweets(String profileName,String profileScreenName, String tweetText, String repliesNumber, String retweetsNumber,String likesNumber)
    {
        this.ProfileName=profileName;
        this.ProfileScreenName="@" + profileScreenName;
        this.TweetText=tweetText;
        this.RepliesNumber=repliesNumber;
        this.RetweetsNumber=retweetsNumber;
        this.LikesNumber=likesNumber;
    }
}
