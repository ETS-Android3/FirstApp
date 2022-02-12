package com.example.myfirstapp.main.Controllers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.UseCases.GenreViewSort;
import com.example.myfirstapp.main.UseCases.GetRecipe;

import java.util.ArrayList;


public class UserRequestBrowse {


    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<String> browseGenres(String username) {
        User user = Constants.USERSECURITY.getUsernames().get(username);
        GenreViewSort genres = new GenreViewSort();
        return genres.genresViewList(Constants.GENRELIBRARY.getAllGenres(), user);
    }

    public ArrayList<Preview> browseSavedRecipes(String username) {
        GetRecipe getRecipe = new GetRecipe();
        User user = Constants.USERSECURITY.getUserByID(username);
        return getRecipe.getUserSavedRecipes(user);
    }

    public ArrayList<Preview> browseGenreRecipes(String genre) {
        GetRecipe get = new GetRecipe();
        return get.getGenreRecipes(Constants.GENRELIBRARY.getAllRecipes(genre));
    }
}

