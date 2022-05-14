package com.example.widgetapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

public class Action {

    private String name;
    private String description;
    private Shortcut task;
    private boolean checked = false;
    private Drawable logo;
    private Drawable logo2;
    public boolean customLogo = false;

    public Action() {}
    public Action(String name, String description, Drawable logo, Shortcut shortcut) {
        this.name = name;
        this.description = description;
        this.logo = logo;
        this.task = shortcut;
    }

    public String getName() { return this.name; };
    public void setName(String name) { this.name = name; }
    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isChecked() { return this.checked; }
    public void setChecked(boolean status) { this.checked = status; }
    public Drawable getLogo() { return logo; };
    public Drawable getLogo2() { return logo2; }
    public void setLogo(Drawable logo1, Drawable logo2) {
        this.logo = logo1;
        this.logo2 = logo2;
        customLogo = true;
    }
    public ArrayList<String> getInfo() { return this.task.getInfo(); }
    public void setInfo(ArrayList<String> info) { this.task.setInfo(info); }
    public Shortcut getTask() { return this.task; }

    public void runTask(Context context) {
        this.task.run(context);
    }
}
