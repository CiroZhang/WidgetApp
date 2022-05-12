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
    public void setLogo(Drawable logo) { this.logo = logo; };
    public ArrayList<String> getInfo() { return this.task.getInfo(); }
    public void setInfo(ArrayList<String> info) { this.task.setInfo(info); }
    public Shortcut getTask() { return this.task; }

    public void runTask(Context context) {
        this.task.run(context);
    }
}
