package com.example.myfirstapp.main.Entities;


import java.util.ArrayList;

public class Preview {

    private int ID;
    private String name;
    private int rating;
    private ArrayList<String> genre;
    private String description;


    public Preview() {
    }

    ;

    public Preview(Recipe recipe) {
        this.ID = recipe.getID();
        this.name = recipe.getName();
        this.rating = recipe.getRating();
        this.genre = recipe.getGenre();
        this.description = recipe.getDescription();
    }

    public Preview(int id, String n, int rate, ArrayList<String> genres, String description) {
        this.ID = id;
        this.name = n;
        this.rating = rate;
        this.genre = genres;
        this.description = description;
    }


    public ArrayList<String> getGenre() {
        return genre;
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

    public String getDescription() {
        return description;
    }



    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public ArrayList<Object> toList() {
        ArrayList<Object> lst = new ArrayList<Object>();
        lst.add(ID);
        lst.add(name);
        lst.add(rating);
        lst.add(genre);
        lst.add(description);
        return lst;
    }

}
