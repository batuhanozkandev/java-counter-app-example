package com.example.counterapp;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    private static Context context;

    public MySharedPreferences(Context context) {
        this.context = context;
    }

    public void setMyIntValue(String key, int value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPreferences", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();

    }
    public int getMyIntValue(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPreferences", 0);
        return sharedPreferences.getInt(key,0);
    }

}
