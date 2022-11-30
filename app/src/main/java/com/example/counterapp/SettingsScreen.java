package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SettingsScreen extends AppCompatActivity {

    Button saveButton;
    EditText maxLimit;
    EditText minLimit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        saveButton = findViewById(R.id.saveButton);
        maxLimit = findViewById(R.id.maxLimit);
        minLimit = findViewById(R.id.minLimit);

        saveButton.setOnClickListener(
                view -> {
                    MySharedPreferences mySharedPreferences = new MySharedPreferences(this);
                    mySharedPreferences.setMyIntValue("maxLimit", Integer.parseInt(String.valueOf(maxLimit.getText())));
                    mySharedPreferences.setMyIntValue("minLimit", Integer.parseInt(String.valueOf(minLimit.getText())));
                    startActivity(new Intent(SettingsScreen.this, MainActivity.class));
                }
        );


    }
}