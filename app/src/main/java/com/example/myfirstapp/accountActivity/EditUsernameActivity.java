package com.example.myfirstapp.accountActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.Notification;
import com.example.myfirstapp.R;

public class EditUsernameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_username);
        setTitle("Your Username");
    }

    public void editUserName(View view) {
        EditText editText = (EditText) findViewById(R.id.editUserNameText);
        String username = editText.getText().toString();
        if (username.isEmpty()) {
            Notification.displaySnackBar(findViewById(R.id.editUsernamePage), "Username cannot be empty");
            return;
        }
        if (Globals.setUser_username(username)) {
            finish();
        } else {
            Notification.displaySnackBar(findViewById(R.id.editUsernamePage), "Username is unavailable");
            return;
        }
    }
}