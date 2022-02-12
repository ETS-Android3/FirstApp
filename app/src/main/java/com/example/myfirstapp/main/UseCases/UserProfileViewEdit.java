package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserInfo;
import com.example.myfirstapp.main.Entities.UserSecurity;

import java.util.ArrayList;

public class UserProfileViewEdit {

    public UserInfo get(User user) {
        return user.getProfile();
    }


    public void editUsername(String username, String newUsername, UserSecurity userSecurity) {
        userSecurity.changeUsername(username, newUsername);
    }

    public void editPassword(String username, String newPassword, UserSecurity userSecurity) {
        userSecurity.changePassword(username, newPassword);
    }

    public void editBio(String username, String newBio, UserSecurity userSecurity) {
        userSecurity.changeBio(username, newBio);
    }

    public void editAge(String username, int newAge, UserSecurity userSecurity) {
        userSecurity.changeAge(username, newAge);
    }

    public void editName(String username, String newName, UserSecurity userSecurity) {
        userSecurity.changeName(username, newName);
    }

    public void editInterests(String username, ArrayList<String> interests, UserSecurity userSecurity) {
        userSecurity.changeInterests(username, interests);
    }
}
