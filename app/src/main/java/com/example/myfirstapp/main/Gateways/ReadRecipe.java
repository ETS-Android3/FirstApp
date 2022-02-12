package com.example.myfirstapp.main.Gateways;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

public class ReadRecipe {

    public static Recipe readRecipe(DataSnapshot singleRecipeRef) {
        int recipeID = singleRecipeRef.child("id").getValue(Integer.class);
        String recipeDescription = singleRecipeRef.child("description").getValue(String.class);
        ArrayList<String> recipeGenres = new ArrayList<>();
        DataSnapshot recipeGenreListDatabase = singleRecipeRef.child("genre");
        for (DataSnapshot genre : recipeGenreListDatabase.getChildren()) {
            recipeGenres.add(genre.getValue(String.class));
        }
        String recipeImage = singleRecipeRef.child("image").getValue(String.class);
        String recipeIngredients = singleRecipeRef.child("ingredients").getValue(String.class);
        String recipeInstructions = singleRecipeRef.child("instructions").getValue(String.class);
        String recipeName = singleRecipeRef.child("name").getValue(String.class);
        int recipePreptime = recipePrepReader(singleRecipeRef);
        int recipeRating = recipeRatingReader(singleRecipeRef);

        Recipe newRecipe = new Recipe(recipeInstructions, recipeIngredients,
                recipeGenres, recipeName, recipeRating, recipeID, recipeImage,
                recipeDescription, recipePreptime);
        DataSnapshot recipeReviewsSnapshot = singleRecipeRef.child("RecipeReviews");
        for (DataSnapshot recipeReviewSnap : recipeReviewsSnapshot.getChildren()) {
            Review recipeReview = ReadReview.readReview(recipeReviewSnap);
            newRecipe.addSavedReviews(recipeReview.getUsername(), recipeReview);
        }

        return newRecipe;
    }

    private static int recipePrepReader(DataSnapshot singleRecipeRef) {
        if (singleRecipeRef.child("prep time").exists()) {
            Object recipePrepHolder = singleRecipeRef.child("preptime").getValue();

            if (recipePrepHolder instanceof Integer) {
                return (Integer) recipePrepHolder;

            }
        }
        return 60;


    }


    private static int recipeRatingReader(DataSnapshot singleRecipeRef) {
        if (singleRecipeRef.child("rating").exists()) {
            if (!(singleRecipeRef.child("rating").getValue(Integer.class) == null)) {
                return singleRecipeRef.child("rating").getValue(Integer.class);
            }
        }
        return 3;
    }
}
