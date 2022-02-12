package com.example.myfirstapp.main.Controllers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.UseCases.RecommendRecipe;

import java.util.ArrayList;

public class UserRequestRecommend {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Preview> recommendRecipes(String username, int num) {
        User user = Constants.USERSECURITY.getUserByID(username);
        RecommendRecipe recipe = new RecommendRecipe();
        return recipe.recommend(user, num, Constants.GENRELIBRARY);
    }
}
