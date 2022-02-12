package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.UseCases.FilterRecipes;

import java.util.ArrayList;

public class UserRequestFilter {

    public ArrayList<Preview> filter(ArrayList<Preview> recipes, String filterkey) {
        FilterRecipes filter = new FilterRecipes(recipes, filterkey);
        return filter.filterRecipes();
    }
}

