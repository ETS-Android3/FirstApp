package com.example.myfirstapp.main.Entities;

import java.util.ArrayList;

public class UserInfo {

    private String username;
    private String password;
    private String displayName;
    private int age;
    private String biography;
    private ArrayList<String> interests;


    public UserInfo() {
    }

    public UserInfo(String username, String password, String displayName, int age, String biography,
                    ArrayList<String> interests) {
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.age = age;
        this.biography = biography;
        this.interests = interests;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getAge() {
        return age;
    }

    public String getBiography() {
        return biography;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }


}
