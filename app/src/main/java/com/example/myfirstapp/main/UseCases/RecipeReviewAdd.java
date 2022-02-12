package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.Entities.User;

public class RecipeReviewAdd {

    public Review addReview(User accUser, Recipe recipe, String comment, int rating) {
        int recipeID = recipe.getID();
        String username = accUser.getUsername();
        if (accUser.getUserReviews().containsKey(recipeID)) {
            return null;
        } else {
            Review review = new Review(username, recipeID, comment, rating);
            accUser.addSavedReviews(recipeID, review);
            recipe.addSavedReviews(username, review);
            return review;
        }
    }
}
