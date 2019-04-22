package com.example.narim.novaa;

public class EditProfileResult {
    private String _id;
    private String screen_name;
    private String name;
    private String location = null;
    private String bio = null;


    // Getter Methods

    public String get_id() {
        return _id;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getBio() {
        return bio;
    }

    // Setter Methods

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}