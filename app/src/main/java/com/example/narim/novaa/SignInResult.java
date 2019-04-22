package com.example.narim.novaa;

import java.util.ArrayList;

public class SignInResult {
    private boolean verified;
    private String location = null;
    private String bio = null;
    private float followers_count;
    private float favorites_count;
    private float friends_count;
    private float novas_count;
    ArrayList< Object > novas_IDs = new ArrayList < Object > ();
    ArrayList < Object > favorites_novas_IDs = new ArrayList < Object > ();
    private String profile_background_color = null;
    private String profile_background_image_url;
    private String profile_image_url;
    private boolean default_profile;
    private boolean default_profile_image;
    private String _id;
    private String name;
    private String email;
    private String screen_name;
    private String password;
    private String created_at;
    private float __v;


    // Getter Methods

    public boolean getVerified() {
        return verified;
    }

    public String getLocation() {
        return location;
    }

    public String getBio() {
        return bio;
    }

    public float getFollowers_count() {
        return followers_count;
    }

    public float getFavorites_count() {
        return favorites_count;
    }

    public float getFriends_count() {
        return friends_count;
    }

    public float getNovas_count() {
        return novas_count;
    }

    public String getProfile_background_color() {
        return profile_background_color;
    }

    public String getProfile_background_image_url() {
        return profile_background_image_url;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public boolean getDefault_profile() {
        return default_profile;
    }

    public boolean getDefault_profile_image() {
        return default_profile_image;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public String getPassword() {
        return password;
    }

    public String getCreated_at() {
        return created_at;
    }

    public float get__v() {
        return __v;
    }

    // Setter Methods

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setFollowers_count(float followers_count) {
        this.followers_count = followers_count;
    }

    public void setFavorites_count(float favorites_count) {
        this.favorites_count = favorites_count;
    }

    public void setFriends_count(float friends_count) {
        this.friends_count = friends_count;
    }

    public void setNovas_count(float novas_count) {
        this.novas_count = novas_count;
    }

    public void setProfile_background_color(String profile_background_color) {
        this.profile_background_color = profile_background_color;
    }

    public void setProfile_background_image_url(String profile_background_image_url) {
        this.profile_background_image_url = profile_background_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public void setDefault_profile(boolean default_profile) {
        this.default_profile = default_profile;
    }

    public void setDefault_profile_image(boolean default_profile_image) {
        this.default_profile_image = default_profile_image;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void set__v(float __v) {
        this.__v = __v;
    }
}
/*
public class SignInResult {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("msg")
    @Expose
    private String message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
*/
