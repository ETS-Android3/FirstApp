package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Gateways.Update;
import com.example.myfirstapp.main.UseCases.RecipeSave;

public class UserRequestSaveRecipe {
    private RecipeSave recipeSave = new RecipeSave();

    public boolean saveRecipe(String username, String recipeID) {
        Recipe recipe = Constants.GENRELIBRARY.getRecipeByID("All", Integer.parseInt(recipeID));
        User user = Constants.USERSECURITY.getUserByID(username);
        try {
            recipeSave.saveToUser(user, recipe);
            Update.recipesSaved(user);
            Update.userGenreWeights(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean deleteRecipe(String username, String recipeID) {
        User user = Constants.USERSECURITY.getUserByID(username);
        Recipe recipe = Constants.GENRELIBRARY.getRecipeByID("All", Integer.parseInt(recipeID));
        try {
            recipeSave.deleteFromUser(user, recipe);
            Update.recipesSaved(user);
            Update.userGenreWeights(user);
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}
