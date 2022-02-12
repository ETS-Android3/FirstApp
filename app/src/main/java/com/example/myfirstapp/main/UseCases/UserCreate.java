package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.User;

import java.util.ArrayList;
import java.util.HashMap;

public class UserCreate {

    public User userCreate(String username, String password, String displayName, int age, String biography,
                           ArrayList<String> interests, HashMap<String, User> existingUsers, ArrayList<String> genreList) {
        if (existingUsers.containsKey(username)) {
            return null;
        } else {
            User newUser = new User(username, password, displayName, age, biography, interests, genreList);
            return newUser;
        }
    }
}