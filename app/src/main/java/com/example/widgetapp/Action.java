package com.example.widgetapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

public class Action {

    private String name;
    private String description;
    private Intent action;
    private boolean checked = false;
    private ImageView logo;

    public Action() {}
    public Action(String name, String description, Drawable logo, Context context) {
        this.name = name;
        this.description = description;
        this.logo = new ImageView(context);
        this.logo.setBackground(logo);
    }

    public String getName() { return this.name; };
    public void setName(String name) { this.name = name; }
    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isChecked() { return this.checked; }
    public void setChecked(boolean status) { this.checked = status; }
    public ImageView getLogo() { return logo; };
    public void setLogo(ImageView logo) { this.logo = logo; };
}
