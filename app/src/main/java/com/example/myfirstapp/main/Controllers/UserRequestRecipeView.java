package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.UseCases.GetRecipe;

public class UserRequestRecipeView {

    public Preview recipeView(String id) throws Exception {
        GetRecipe getRecipe = new GetRecipe();
        try {
            Recipe recipe = Constants.GENRELIBRARY.getRecipeByID("All", Integer.parseInt(id));
            return getRecipe.getSingleRecipe(recipe, "full");
        } catch (Exception e) {
            System.out.println("Not a valid recipe ID.");
        }
        return getRecipe.getSingleRecipe(Constants.GENRELIBRARY.getRecipeByID("All", Integer.parseInt(id)), "full");
    }
}
