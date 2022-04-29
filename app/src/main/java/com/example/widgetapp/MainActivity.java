package com.example.widgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Shortcut> shortcutsList = new ArrayList<>();
    public static ArrayList<Shortcut> availableShortcuts = new ArrayList<>();
    public static ArrayList<Shortcut> updatedSearchShortcuts = new ArrayList<>();
    public static Shortcut currentShortcut = new Shortcut();
    public static ArrayList<Action> shortcutActions = new ArrayList<>();
    public static Action actionToAdd = new Action();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void updateAvailableShortcuts() {
        updatedSearchShortcuts.clear();
        for (Shortcut s : availableShortcuts) {
            updatedSearchShortcuts.add(s);
        }
    }

    public static void updateShortcutActions(Shortcut s) {
        MainActivity.shortcutActions.clear();
        for (Action action : s.getShortcutActions()) {
            shortcutActions.add(action);
        }
    }
}