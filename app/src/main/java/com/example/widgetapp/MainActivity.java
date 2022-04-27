package com.example.widgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Shortcut> shortcutsList = new ArrayList<>();
    public static ArrayList<Shortcut> availableShortcuts = new ArrayList<>();
    public static ArrayList<Shortcut> updatedSearchShortcuts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void updateAvailableShortcuts() {
        updatedSearchShortcuts.clear();
        updatedSearchShortcuts = (ArrayList<Shortcut>)availableShortcuts.clone();
    }
}