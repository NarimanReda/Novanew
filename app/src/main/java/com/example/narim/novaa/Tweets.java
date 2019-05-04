package com.example.narim.novaa;

public class Tweets {
    String ProfileName;
    String ProfileScreenName;
    String TweetText;
    String RepliesNumber;
    String RetweetsNumber;
    String LikesNumber;
    Boolean Renovad;
    String id;
    
    public Tweets(String id,String profileName,String profileScreenName, String tweetText, String repliesNumber, String retweetsNumber,String likesNumber,Boolean renovad)
    {
        this.id=id;
        this.ProfileName=profileName;
        this.ProfileScreenName="@" + profileScreenName;
        this.TweetText=tweetText;
        this.RepliesNumber=repliesNumber;
        this.RetweetsNumber=retweetsNumber;
        this.LikesNumber=likesNumber;
        this.Renovad=renovad;
    }
}
