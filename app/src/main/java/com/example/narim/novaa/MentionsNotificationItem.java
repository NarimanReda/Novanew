package com.example.narim.novaa;

public class MentionsNotificationItem {
    String UserWhoMentions;
    String TweetMentionedIn;

    public MentionsNotificationItem(String person_name, String tweet)
    {
        this.UserWhoMentions = person_name;
        this.TweetMentionedIn = tweet;
    }
}
