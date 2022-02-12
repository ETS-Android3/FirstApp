package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Gateways.Create;
import com.example.myfirstapp.main.UseCases.UserCreate;

import java.util.ArrayList;


public class UserRequestCreateLogin {

    public String createUser(String username, String password, String displayName,
                             int age, String biography, ArrayList<String> interestList) throws Exception {
        UserCreate userCreate = new UserCreate();
        User user = userCreate.userCreate(username, password, displayName, age,
                biography, interestList, Constants.USERSECURITY.getUsernames(), Constants.GENRELIST);
        if (user != null) {
            Constants.USERSECURITY.addUser(user);
            Create.createUser(user);
            return username;
        } else {
            throw new Exception("There was an error.");
        }
    }


    public boolean loginUser(String username, String password) {
        return Constants.USERSECURITY.checkPassword(username, password);
    }
}