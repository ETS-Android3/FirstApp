package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Preview;

import java.util.ArrayList;
import java.util.Collections;

public class SortRecipes {
    public ArrayList<Preview> recipes;

    public SortRecipes(ArrayList<Preview> previews) {
        this.recipes = previews;
    }

    public ArrayList<Preview> sort() {
        return alphabet();
    }

    public ArrayList<Preview> alphabet() {
        ArrayList<Preview> output_lst = new ArrayList<Preview>();
        ArrayList<String> names = new ArrayList<String>();
        for (Preview preview : this.recipes) {
            String name = preview.getName();
            names.add(name);
        }
        Collections.sort(names);
        for (String name : names) {
            for (Preview preview : this.recipes) {
                if (preview.getName().equals(name)) {
                    output_lst.add(preview);
                }
            }
        }
        return output_lst;
    }
}


