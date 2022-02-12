package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;

import java.util.ArrayList;

public class RecipeSave {


    public boolean saveToUser(User user, Recipe recipe) throws Exception {
        ArrayList<Recipe> recipeList = user.getSavedRecipes();
        if (recipeList.contains(recipe)) {
            throw new Exception("Recipe is already saved");
        } else {
            user.addSavedRecipes(recipe);
            return true;
        }
    }




    public boolean deleteFromUser(User user, Recipe recipe) throws Exception {
        ArrayList<Recipe> recipeList = user.getSavedRecipes();
        for (Recipe savedRecipe : recipeList) {
            if (savedRecipe.getID() == recipe.getID()) {
                user.removeSavedRecipes(savedRecipe);
                return true;
            }
        }
        throw new Exception("Recipe not in saved recipes.");
    }
}