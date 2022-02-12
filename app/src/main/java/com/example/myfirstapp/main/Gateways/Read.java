package com.example.myfirstapp.main.Gateways;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserSecurity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Read {

    private static final DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private static final DatabaseReference mRecipeRef = mRootRef.child("recipes");
    private static final DatabaseReference mUserRef = mRootRef.child("users");

    public interface userDataStatus {
        void userSecurityLoaded(UserSecurity userSecurity);
    }

    public interface recipeDataStatus {
        void genreLibraryLoaded(GenreLibrary genreLibrary);
    }

    public static void populateUserSecurity(final userDataStatus dataStatus) {
        final UserSecurity[] populatedUserSecurity = {new UserSecurity()};

        mUserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Populate the UserSecurity object
                UserSecurity newUserSecurity = Read.fillUserSecurity(dataSnapshot);
                dataStatus.userSecurityLoaded(newUserSecurity);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("ArpiTestApp", "Error.");
            }
        });
    }



    private static UserSecurity fillUserSecurity(DataSnapshot dataSnapshot) {
        UserSecurity usersUserSecurity = new UserSecurity();
        for (DataSnapshot singleUserRef : dataSnapshot.getChildren()) {
            User user = ReadUser.readUser(singleUserRef);
            usersUserSecurity.addUser(user);
        }

        return usersUserSecurity;
    }


    public static void populateGenreLibrary(final recipeDataStatus dataStatus) {
        mRecipeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Populate the GenreLibrary object
                GenreLibrary newGenreLibrary = Read.fillGenreLibrary(dataSnapshot);
                dataStatus.genreLibraryLoaded(newGenreLibrary);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("ArpiTestApp", "Error.");
            }
        });
    }

    private static GenreLibrary fillGenreLibrary(DataSnapshot dataSnapshot) {
        GenreLibrary genreLibrary = new GenreLibrary();
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Recipe recipe = ReadRecipe.readRecipe(ds);
            for (String genre : recipe.getGenre()) {
                genreLibrary.addRecipes(genre, recipe);
            }

        }
        return genreLibrary;
    }
}