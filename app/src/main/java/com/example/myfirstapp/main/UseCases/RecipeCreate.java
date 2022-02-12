package com.example.myfirstapp.main.UseCases;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.Recipe;

import java.util.ArrayList;

public class RecipeCreate {


    @RequiresApi(api = Build.VERSION_CODES.O)
    public Recipe CreateRecipeFromUser(String instructions, String ingredients, ArrayList<String> genres, String name,
                                       int rating, int ID, String image,
                                       String descriptions, int preptime, GenreLibrary genreLibrary) {

        Recipe recipe = new Recipe(instructions, ingredients, genres, name, rating, ID, image, descriptions, preptime);
        for (String genre : recipe.getGenre()) {
            genreLibrary.addRecipes(genre, recipe);
        }
        return recipe;
    }
}
