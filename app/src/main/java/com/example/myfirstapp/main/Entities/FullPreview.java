package com.example.myfirstapp.main.Entities;

import java.util.ArrayList;

public class FullPreview extends Preview {
    private int ID;
    private String name;
    private int rating;
    private ArrayList<String> genre;
    private String description;
    private String image;
    private int preptime;
    private String ingredients;
    private String instructions;

    public FullPreview(Recipe recipe) {
        super(recipe.getID(), recipe.getName(), recipe.getRating(), recipe.getGenre(), recipe.getDescription());
        this.image = recipe.getImage();
        this.preptime = recipe.getPreptime();
        this.ingredients = recipe.getIngredients();
        this.instructions = recipe.getInstructions();
    }

    public String getImage() {
        return image;
    }

    public int getPreptime() {
        return preptime;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }


    // TODO: docstring


    public void setImage(String img) {
        this.image = img;
    }

    public void setPreptime(int rating) {
        this.rating = rating;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}
