package com.example.myfirstapp.main.Entities;

import java.util.ArrayList;
import java.util.HashMap;


public class Recipe {
    private String instructions;
    private String ingredients;
    private ArrayList<String> genre;
    private String name;
    private int rating;
    private int ID;
    private HashMap<String, Review> RecipeReviews;
    private String image;
    private String description;
    private Preview preview;
    private int preptime;
    private FullPreview full;
    private ArrayList<Integer> ratingList;


    public Recipe() {
    }

    public Recipe(String instructions, String ingredients, ArrayList<String> g, String name, int rating, int id, String img,
                  String description, int preptime) {
        this.instructions = instructions;
        this.ingredients = ingredients;
        ArrayList<String> genres = new ArrayList<>();
        genres.add("All");
        genres.addAll(g);
        this.genre = genres;
        this.name = name;
        this.rating = rating;
        this.ID = id;
        this.image = img;
        this.description = description;
        this.preptime = preptime;
        this.RecipeReviews = new HashMap<>();
        this.preview = new Preview(id, name, rating, genres, description);
        this.full = new FullPreview(this);
        ArrayList<Integer> ratings = new ArrayList<>();
        ratings.add(rating);
        this.ratingList = ratings;
    }



    public String getInstructions() {
        return instructions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public String getGenreStrings() {
        StringBuilder s = new StringBuilder();
        int counter = 1;
        for (String str : genre) {
            if (counter < genre.size()) {
                counter++;
                s.append(str).append(", ");
            } else {
                s.append(str);
            }
        }
        return s.toString();
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getID() {
        return ID;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, Review> getRecipeReviews() {
        return RecipeReviews;
    }

    public int getPreptime() {
        return preptime;
    }

    public ArrayList<Integer> getRatingList() {
        return ratingList;
    }


    public Preview getPreview() {
        return preview;
    }

    public FullPreview getFull() {
        return full;
    }


    public void setInstructions(String instructions) {
        this.instructions = instructions;
        this.full.setInstructions(instructions);
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
        this.full.setIngredients(ingredients);
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
        this.preview.setGenre(genre);
    }

    public void setRating(int rating) {
        this.rating = rating;
        this.preview.setRating(rating);
    }

    public void setID(int ID) {
        this.ID = ID;
        this.preview.setID(ID);
    }

    public void setName(String name) {
        this.name = name;
        this.preview.setName(name);
    }

    public void setDescription(String description) {
        this.description = description;
        this.preview.setDescription(description);
    }

    public void setImage(String image) {
        this.image = image;
        this.full.setImage(image);
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
        this.full.setPreptime(preptime);
    }


    public void addSavedReviews(String username, Review review) {
        this.RecipeReviews.put(username, review);
        this.ratingList.add(review.getRating());
        double sum = 0;
        for (Integer i : ratingList)
            sum += i;
        this.rating = (int) Math.round(sum / ratingList.size());
    }

}


