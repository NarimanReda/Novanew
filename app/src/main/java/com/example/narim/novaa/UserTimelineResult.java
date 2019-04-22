package com.example.narim.novaa;

import java.util.ArrayList;

public class UserTimelineResult {
    private String in_reply_to_status_id = null;
    private String in_reply_to_user_id = null;
    private String in_reply_to_screen_name = null;
    private float reply_count;
    private float renova_count;
    private float favorite_count;
    ArrayList< Object > favorited_by_IDs = new ArrayList < Object > ();
    ArrayList < Object > renovaed_by_IDs = new ArrayList < Object > ();
    ArrayList < Object > replied_novas_IDs = new ArrayList < Object > ();
    private String _id;
    private String text;
    private String user;
    private boolean favorited;
    private boolean renovaed;
    private String entitiesObject = null;
    private String created_at;
    private float __v;


    // Getter Methods

    public String getIn_reply_to_status_id() {
        return in_reply_to_status_id;
    }

    public String getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    public String getIn_reply_to_screen_name() {
        return in_reply_to_screen_name;
    }

    public float getReply_count() {
        return reply_count;
    }

    public float getRenova_count() {
        return renova_count;
    }

    public float getFavorite_count() {
        return favorite_count;
    }

    public String get_id() {
        return _id;
    }

    public String getText() {
        return text;
    }

    public String getUser() {
        return user;
    }

    public boolean getFavorited() {
        return favorited;
    }

    public boolean getRenovaed() {
        return renovaed;
    }

    public String getEntitiesObject() {
        return entitiesObject;
    }

    public String getCreated_at() {
        return created_at;
    }

    public float get__v() {
        return __v;
    }

    // Setter Methods

    public void setIn_reply_to_status_id(String in_reply_to_status_id) {
        this.in_reply_to_status_id = in_reply_to_status_id;
    }

    public void setIn_reply_to_user_id(String in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    public void setReply_count(float reply_count) {
        this.reply_count = reply_count;
    }

    public void setRenova_count(float renova_count) {
        this.renova_count = renova_count;
    }

    public void setFavorite_count(float favorite_count) {
        this.favorite_count = favorite_count;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public void setRenovaed(boolean renovaed) {
        this.renovaed = renovaed;
    }

    public void setEntitiesObject(String entitiesObject) {
        this.entitiesObject = entitiesObject;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void set__v(float __v) {
        this.__v = __v;
    }
}