package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button increaseButton;
    Button decreaseButton;
    Button settingsButton;
    TextView counterText;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        increaseButton = findViewById(R.id.increaseButton);
        decreaseButton = findViewById(R.id.decreaseButton);
        settingsButton = findViewById(R.id.settingsButton);
        counterText = findViewById(R.id.counter);

        increaseButton.setOnClickListener(
                view -> {
                    count = count + 1;
                    counterText.setText(String.valueOf(count));
                    IsMaxOrMinLimit(count);
                }
        );
        decreaseButton.setOnClickListener(
                view -> {
                    count = count - 1;
                    counterText.setText(String.valueOf(count));
                    IsMaxOrMinLimit(count);
                }
        );
        settingsButton.setOnClickListener(
                view -> {
                    startActivity(new Intent(MainActivity.this, SettingsScreen.class));
                }
        );





    }
    public void IsMaxOrMinLimit(int value){
        MySharedPreferences mySharedPreferences = new MySharedPreferences(this);

        int maxLimit = mySharedPreferences.getMyIntValue("maxLimit");
        int minLimit = mySharedPreferences.getMyIntValue("minLimit");
        if(value == maxLimit){
            Toast.makeText(this, "Maksimum limite ulaştınız!",
                    Toast.LENGTH_LONG).show();
        }
        else if(value == minLimit){
            Toast.makeText(this, "Minimum limite ulaştınız!",
                    Toast.LENGTH_LONG).show();
        }
    }
}