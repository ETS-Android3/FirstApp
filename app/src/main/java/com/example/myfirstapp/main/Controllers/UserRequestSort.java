package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.UseCases.SortByInterests;
import com.example.myfirstapp.main.UseCases.SortByRating;
import com.example.myfirstapp.main.UseCases.SortRecipes;

import java.util.ArrayList;

public class UserRequestSort {


    public ArrayList<Preview> sort(ArrayList<Preview> recipes, String sortkey) {
        if (sortkey.isEmpty()) {
            SortRecipes sortRecipes = new SortRecipes(recipes);
            return sortRecipes.sort();
        } else if (sortkey.equals("Rating")) {
            SortByRating sortRecipes = new SortByRating(recipes);
            return sortRecipes.sort();
        } else {
            return null;
        }
    }




    public ArrayList<Preview> sort(ArrayList<Preview> recipes, String sortkey, String username) {
        User user = Constants.USERSECURITY.getUsernames().get(username);
        if (sortkey.isEmpty()) {
            SortRecipes sortRecipes = new SortRecipes(recipes);
            return sortRecipes.sort();
        } else if (sortkey.equals("Rating")) {
            SortByRating sortRecipes = new SortByRating(recipes);
            return sortRecipes.sort();
        } else if (sortkey.equals("Interests")) {
            SortByInterests sortRecipes = new SortByInterests(recipes, user);
            return sortRecipes.sort();
        } else {
            return null;
        }
    }


}
