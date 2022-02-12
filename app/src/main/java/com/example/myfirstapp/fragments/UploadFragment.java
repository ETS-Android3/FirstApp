package com.example.myfirstapp.fragments;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.MainActivity;
import com.example.myfirstapp.Notification;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Controllers.UserRequestCreateRecipe;
import com.example.myfirstapp.main.Gateways.Constants;

import java.util.ArrayList;
import java.util.Collections;

public class UploadFragment extends Fragment {


    private boolean[] selectedInterest;
    private ArrayList<Integer> interestList = new ArrayList<>();
    private ArrayList<String> genres = Constants.GENRELIBRARY.getUploadGenres();
    private String[] genreList = new String[genres.size()];

    public UploadFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static UploadFragment newInstance(String param1, String param2) {
        UploadFragment fragment = new UploadFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_upload, container, false);

        genreList = genres.toArray(genreList);
        TextView interestText = (TextView) v.findViewById(R.id.uploadGenreInput);
        selectedInterest = new boolean[genreList.length];
        String[] finalGenreList = genreList;
        interestText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                builder.setTitle("Select Genres");

                builder.setCancelable(false);

                builder.setMultiChoiceItems(finalGenreList, selectedInterest, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b) {
                            interestList.add(i);
                            Collections.sort(interestList);
                        } else {
                            interestList.remove(Integer.valueOf(i));
                        }
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int j = 0; j < interestList.size(); j++) {
                            stringBuilder.append(finalGenreList[interestList.get(j)]);
                            if (j != interestList.size() - 1) {
                                stringBuilder.append(", ");
                            }
                        }
                        interestText.setText(stringBuilder.toString());
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for (int j = 0; j < selectedInterest.length; j++) {
                            selectedInterest[j] = false;
                            interestList.clear();
                            interestText.setText("");
                        }
                    }
                });
                builder.show();
            }
        });

        Button b = v.findViewById(R.id.uploadButtonSubmit);
        UploadFragment that = this;
        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v_useless) {
                that.onSubmit(v);
            }
        });

        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onSubmit(View view) {
        EditText uploadTextName = (EditText) view.findViewById(R.id.uploadTextName);
        EditText uploadTextInstructions = (EditText) view.findViewById(R.id.uploadTextInstructions);
        EditText uploadTextIngredients = (EditText) view.findViewById(R.id.uploadTextIngredients);
        EditText uploadTextDescription = (EditText) view.findViewById(R.id.uploadTextDescription);
        EditText uploadTextImage = (EditText) view.findViewById(R.id.uploadTextImage);
        EditText uploadTextPreptime = (EditText) view.findViewById(R.id.uploadTextPreptime);

        String name = uploadTextName.getText().toString();
        String instructions = uploadTextInstructions.getText().toString();
        String ingredients = uploadTextIngredients.getText().toString();
        String description = uploadTextDescription.getText().toString();
        String image = uploadTextImage.getText().toString();
        String preptime_str = uploadTextPreptime.getText().toString();


        ArrayList<String> uploadGenres = new ArrayList<>();
        for (int genre : interestList) {
            uploadGenres.add(genreList[genre]);
        }

        if (name.isEmpty() || instructions.isEmpty() || ingredients.isEmpty()
                || description.isEmpty() || image.isEmpty() || preptime_str.isEmpty()) {
            Notification.displaySnackBar(getView().findViewById(R.id.UploadPage), "Please fill in everything");
            return;
        } else {
            int id = Constants.GENRELIBRARY.getNewId();
            UserRequestCreateRecipe recipeController = new UserRequestCreateRecipe();

            recipeController.recipe(
                    Globals.getUser_username(),
                    instructions,
                    ingredients,
                    uploadGenres,
                    name,
                    "0",
                    id,
                    image,
                    description,
                    preptime_str
            );
            MainActivity main = (MainActivity) getActivity();
            main.initFragment(R.id.menu_home);
        }


    }
}