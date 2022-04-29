package com.example.widgetapp;

import android.content.Intent;

public class Action {

    private String name;
    private String description;
    private Intent action;
    private boolean checked = false;

    public Action() {}
    public Action(String name, String description) {

    }

    public String getName() { return this.name; };
    public String getDescription() { return this.description; }
    public boolean isChecked() { return this.checked; }
    public void setChecked(boolean status) { this.checked = status; }
}