package com.example.myfirstapp.main.Gateways;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.Entities.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Update {
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();

    public static void recipeRating(Recipe recipe) {
        DatabaseReference recipeRatingRef = database.getReference("recipes/" + recipe.getID() + "/rating");
        DatabaseReference recipeRatingListRef = database.getReference("recipes/" + recipe.getID() + "/ratingList");
        recipeRatingRef.setValue(recipe.getRating());
        recipeRatingListRef.setValue(recipe.getRatingList());
    }


    public static void recipesSaved(User user) {
        DatabaseReference userSavedRef = database.getReference("users/" + user.getUsername() + "/SavedRecipes");
        userSavedRef.setValue(null);
        for (Recipe recipe : user.getSavedRecipes()) {
            DatabaseReference recipeRef = database.getReference("users/" + user.getUsername() + "/SavedRecipes/" + recipe.getID());
            recipeRef.setValue(recipe);
        }
    }

    public static void reviewCreated(Review review) {
        DatabaseReference userReviewsRef = database.getReference("users/" + review.getUsername() + "/UserReviews/" + review.getRecipeID());
        DatabaseReference recipeReviewsRef = database.getReference("recipes/" + review.getRecipeID() + "/RecipeReviews/" + review.getUsername());

        userReviewsRef.setValue(review);
        recipeReviewsRef.setValue(review);
    }

    public static void userProfile(String username, Object property, String propertyName) {
        DatabaseReference userRef = database.getReference("users/" + username + "/" + propertyName);
        userRef.setValue(property);
    }

    public static void username(String oldUsername, String newUsername, User user) {
        DatabaseReference userRef = database.getReference("users/" + oldUsername);
        userRef.removeValue();
        DatabaseReference newUserRef = database.getReference("users/" + newUsername);
        newUserRef.setValue(user);
    }


    public static void userGenreWeights(User user) {
        DatabaseReference userRef = database.getReference("users/" + user.getUsername() + "/genreWeights");
        userRef.setValue(user.getGenreWeights());
    }
}
