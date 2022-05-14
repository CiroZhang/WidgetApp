package com.example.widgetapp.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.widgetapp.MainActivity;
import com.example.widgetapp.R;

import java.util.ArrayList;
import java.util.Collections;

public class ShortcutCustomize extends AppCompatActivity {

    Activity activity = ShortcutCustomize.this;
    String appName = "";
    Boolean nameEntered = false;
    String colorSelected = "";
    Boolean iconChanged = false;
    Drawable icon1, icon2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shortcut_customize);

        ImageButton nextButton = findViewById(R.id.add_shortcut_button);
        ImageView appIcon = findViewById(R.id.apps_icon);
        ImageView customIconBack = findViewById(R.id.custom_icon_back);
        ImageView customIconFront = findViewById(R.id.custom_icon_front);
        ImageButton backButton = findViewById(R.id.back_button);
        EditText searchEditText = findViewById(R.id.search_edit_text);
        ImageButton clearTextButton = findViewById(R.id.clear_text_button);
        ImageButton useDefaultButton = findViewById(R.id.use_default_icon_button);

        ArrayList<ImageButton> colorsList = new ArrayList<>();
        ImageButton colorPink = findViewById(R.id.color_pink);
        ImageButton colorRed = findViewById(R.id.color_red);
        ImageButton colorOrange = findViewById(R.id.color_orange);
        ImageButton colorLightOrange = findViewById(R.id.color_light_orange);
        ImageButton colorYellow = findViewById(R.id.color_yellow);
        ImageButton colorLime = findViewById(R.id.color_lime);
        ImageButton colorGreen = findViewById(R.id.color_green);
        ImageButton colorDarkGreen = findViewById(R.id.color_dark_green);
        ImageButton colorTeal = findViewById(R.id.color_teal);
        ImageButton colorLightBlue = findViewById(R.id.color_light_blue);
        ImageButton colorBlue = findViewById(R.id.color_blue);
        ImageButton colorDarkBlue = findViewById(R.id.color_dark_blue);
        ImageButton colorMagenta = findViewById(R.id.color_magenta);
        ImageButton colorPurple = findViewById(R.id.color_purple);
        Collections.addAll(colorsList,colorPink,colorRed,colorOrange,colorLightOrange,colorYellow,colorLime,colorGreen,colorDarkGreen,colorTeal,colorLightBlue,colorBlue,colorDarkBlue,colorMagenta,colorPurple);

        ArrayList<ImageButton> iconsList = new ArrayList<>();
        ImageButton iconVideo = findViewById(R.id.icon_video);
        ImageButton iconGallery = findViewById(R.id.icon_gallery);
        ImageButton iconMusic = findViewById(R.id.icon_music);
        ImageButton iconExplore = findViewById(R.id.icon_explore);
        ImageButton iconForward = findViewById(R.id.icon_forward);
        ImageButton iconFolder = findViewById(R.id.icon_folder);
        ImageButton iconShare = findViewById(R.id.icon_share);
        ImageButton iconReport = findViewById(R.id.icon_report);
        ImageButton iconNotes = findViewById(R.id.icon_notes);
        ImageButton iconGame = findViewById(R.id.icon_game);
        ImageButton iconMessage = findViewById(R.id.icon_message);
        ImageButton iconForum = findViewById(R.id.icon_forum);
        ImageButton iconFile = findViewById(R.id.icon_file);
        ImageButton iconEmail = findViewById(R.id.icon_email);
        Collections.addAll(iconsList,iconVideo,iconGallery,iconMusic,iconMusic,iconExplore,iconForward,iconFolder,iconShare,iconReport,iconNotes,iconGame,iconMessage,iconForum, iconFile, iconEmail);

        appIcon.setBackground(MainActivity.currentShortcut.getLogo());

        colorPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorPink.setBackgroundResource(R.drawable.color_pink_checked);
                    colorSelected = "pink";
                }
                else if (colorSelected.equals("pink")) {
                    colorPink.setBackgroundResource(R.drawable.color_pink_checked);
                }
                else {
                    colorSelected=("pink");
                    colorPink.setBackgroundResource(R.drawable.color_pink_checked);
                    colorRed.setBackgroundResource(R.drawable.color_red);
                    colorOrange.setBackgroundResource(R.drawable.color_orange);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow);
                    colorLime.setBackgroundResource(R.drawable.color_lime);
                    colorGreen.setBackgroundResource(R.drawable.color_green);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                    colorTeal.setBackgroundResource(R.drawable.color_teal);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                    colorBlue.setBackgroundResource(R.drawable.color_blue);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                    colorPurple.setBackgroundResource(R.drawable.color_purple);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_pink);
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_pink);
                allCriteriasMet(nextButton);
            }
        });
        colorRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorRed.setBackgroundResource(R.drawable.color_red_checked);
                    colorSelected = "red";
                }
                else if (colorSelected.equals("red")) {
                    colorRed.setBackgroundResource(R.drawable.color_red_checked);
                }
                else {
                    colorSelected=("red");
                    colorPink.setBackgroundResource(R.drawable.color_pink);
                    colorRed.setBackgroundResource(R.drawable.color_red_checked);
                    colorOrange.setBackgroundResource(R.drawable.color_orange);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow);
                    colorLime.setBackgroundResource(R.drawable.color_lime);
                    colorGreen.setBackgroundResource(R.drawable.color_green);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                    colorTeal.setBackgroundResource(R.drawable.color_teal);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                    colorBlue.setBackgroundResource(R.drawable.color_blue);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                    colorPurple.setBackgroundResource(R.drawable.color_purple);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_red);
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_red);
                allCriteriasMet(nextButton);
            }
        });
        colorOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorOrange.setBackgroundResource(R.drawable.color_orange_checked);
                    colorSelected = "orange";
                }
                else if (colorSelected.equals("orange")) {
                    colorOrange.setBackgroundResource(R.drawable.color_orange_checked);
                }
                else {
                    colorSelected=("orange");
                    colorPink.setBackgroundResource(R.drawable.color_pink);
                    colorRed.setBackgroundResource(R.drawable.color_red);
                    colorOrange.setBackgroundResource(R.drawable.color_orange_checked);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow);
                    colorLime.setBackgroundResource(R.drawable.color_lime);
                    colorGreen.setBackgroundResource(R.drawable.color_green);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                    colorTeal.setBackgroundResource(R.drawable.color_teal);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                    colorBlue.setBackgroundResource(R.drawable.color_blue);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                    colorPurple.setBackgroundResource(R.drawable.color_purple);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_orange);
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_orange);
                allCriteriasMet(nextButton);
            }
        });
        colorLightOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorSelected = "light orange";
                }
                else if (colorSelected.equals("light orange")) {
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange_checked);
                }
                else {
                    colorSelected=("light orange");
                    colorPink.setBackgroundResource(R.drawable.color_pink);
                    colorRed.setBackgroundResource(R.drawable.color_red);
                    colorOrange.setBackgroundResource(R.drawable.color_orange);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange_checked);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow);
                    colorLime.setBackgroundResource(R.drawable.color_lime);
                    colorGreen.setBackgroundResource(R.drawable.color_green);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                    colorTeal.setBackgroundResource(R.drawable.color_teal);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                    colorBlue.setBackgroundResource(R.drawable.color_blue);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                    colorPurple.setBackgroundResource(R.drawable.color_purple);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_light_orange);
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_light_orange);
                allCriteriasMet(nextButton);
            }
        });
        colorYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorYellow.setBackgroundResource(R.drawable.color_yellow_checked);
                    colorSelected = "yellow";
                }
                else if (colorSelected.equals("yellow")) {
                    colorYellow.setBackgroundResource(R.drawable.color_yellow_checked);
                }
                else {
                    colorSelected=("yellow");
                    colorPink.setBackgroundResource(R.drawable.color_pink);
                    colorRed.setBackgroundResource(R.drawable.color_red);
                    colorOrange.setBackgroundResource(R.drawable.color_orange);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow_checked);
                    colorLime.setBackgroundResource(R.drawable.color_lime);
                    colorGreen.setBackgroundResource(R.drawable.color_green);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                    colorTeal.setBackgroundResource(R.drawable.color_teal);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                    colorBlue.setBackgroundResource(R.drawable.color_blue);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                    colorPurple.setBackgroundResource(R.drawable.color_purple);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_yellow);
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_yellow);
                allCriteriasMet(nextButton);
            }
        });
        colorLime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorLime.setBackgroundResource(R.drawable.color_lime_checked);
                    colorSelected = "lime";
                }
                else if (colorSelected.equals("lime")) {
                    colorLime.setBackgroundResource(R.drawable.color_lime_checked);
                }
                else {
                    colorSelected=("lime");
                    colorPink.setBackgroundResource(R.drawable.color_pink);
                    colorRed.setBackgroundResource(R.drawable.color_red);
                    colorOrange.setBackgroundResource(R.drawable.color_orange);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow);
                    colorLime.setBackgroundResource(R.drawable.color_lime_checked);
                    colorGreen.setBackgroundResource(R.drawable.color_green);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                    colorTeal.setBackgroundResource(R.drawable.color_teal);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                    colorBlue.setBackgroundResource(R.drawable.color_blue);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                    colorPurple.setBackgroundResource(R.drawable.color_purple);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_lime);
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_lime);
                allCriteriasMet(nextButton);
            }
        });
        colorGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorGreen.setBackgroundResource(R.drawable.color_green_checked);
                    colorSelected = "green";
                }
                else if (colorSelected.equals("green")) {
                    colorGreen.setBackgroundResource(R.drawable.color_green_checked);
                }
                else {
                    colorSelected=("green");
                    colorPink.setBackgroundResource(R.drawable.color_pink);
                    colorRed.setBackgroundResource(R.drawable.color_red);
                    colorOrange.setBackgroundResource(R.drawable.color_orange);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow);
                    colorLime.setBackgroundResource(R.drawable.color_lime);
                    colorGreen.setBackgroundResource(R.drawable.color_green_checked);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                    colorTeal.setBackgroundResource(R.drawable.color_teal);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                    colorBlue.setBackgroundResource(R.drawable.color_blue);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                    colorPurple.setBackgroundResource(R.drawable.color_purple);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_green);
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_green);
                allCriteriasMet(nextButton);
            }
        });
        colorDarkGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green_checked);
                    colorSelected = "dark green";
                }
                else if (colorSelected.equals("dark green")) {
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green_checked);
                }
                else {
                    colorSelected=("dark green");
                    colorPink.setBackgroundResource(R.drawable.color_pink);
                    colorRed.setBackgroundResource(R.drawable.color_red);
                    colorOrange.setBackgroundResource(R.drawable.color_orange);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow);
                    colorLime.setBackgroundResource(R.drawable.color_lime);
                    colorGreen.setBackgroundResource(R.drawable.color_green);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green_checked);
                    colorTeal.setBackgroundResource(R.drawable.color_teal);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                    colorBlue.setBackgroundResource(R.drawable.color_blue);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                    colorPurple.setBackgroundResource(R.drawable.color_purple);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_dark_green);
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_dark_green);
                allCriteriasMet(nextButton);
            }
        });
        colorTeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorTeal.setBackgroundResource(R.drawable.color_teal_checked);
                    colorSelected = "teal";
                }
                else if (colorSelected.equals("teal")) {
                    colorTeal.setBackgroundResource(R.drawable.color_teal_checked);
                }
                else {
                    colorSelected=("teal");
                    colorPink.setBackgroundResource(R.drawable.color_pink);
                    colorRed.setBackgroundResource(R.drawable.color_red);
                    colorOrange.setBackgroundResource(R.drawable.color_orange);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow);
                    colorLime.setBackgroundResource(R.drawable.color_lime);
                    colorGreen.setBackgroundResource(R.drawable.color_green);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                    colorTeal.setBackgroundResource(R.drawable.color_teal_checked);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                    colorBlue.setBackgroundResource(R.drawable.color_blue);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                    colorPurple.setBackgroundResource(R.drawable.color_purple);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_teal);
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_teal);
                allCriteriasMet(nextButton);
            }
        });
        colorLightBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue_checked);
                    colorSelected = "light blue";
                }
                else if (colorSelected.equals("light blue")) {
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue_checked);
                }
                else {
                    colorSelected=("light blue");
                    colorPink.setBackgroundResource(R.drawable.color_pink);
                    colorRed.setBackgroundResource(R.drawable.color_red);
                    colorOrange.setBackgroundResource(R.drawable.color_orange);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow);
                    colorLime.setBackgroundResource(R.drawable.color_lime);
                    colorGreen.setBackgroundResource(R.drawable.color_green);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                    colorTeal.setBackgroundResource(R.drawable.color_teal);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue_checked);
                    colorBlue.setBackgroundResource(R.drawable.color_blue);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                    colorPurple.setBackgroundResource(R.drawable.color_purple);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_light_blue);

                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_light_blue);
                allCriteriasMet(nextButton);
            }
        });
        colorBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorBlue.setBackgroundResource(R.drawable.color_blue_checked);
                    colorSelected = "blue";
                }
                else if (colorSelected.equals("blue")) {
                    colorBlue.setBackgroundResource(R.drawable.color_blue_checked);
                }
                else {
                    colorSelected=("blue");
                    colorPink.setBackgroundResource(R.drawable.color_pink);
                    colorRed.setBackgroundResource(R.drawable.color_red);
                    colorOrange.setBackgroundResource(R.drawable.color_orange);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow);
                    colorLime.setBackgroundResource(R.drawable.color_lime);
                    colorGreen.setBackgroundResource(R.drawable.color_green);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                    colorTeal.setBackgroundResource(R.drawable.color_teal);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                    colorBlue.setBackgroundResource(R.drawable.color_blue_checked);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                    colorPurple.setBackgroundResource(R.drawable.color_purple);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_blue);
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_blue);
                allCriteriasMet(nextButton);
            }
        });
        colorDarkBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue_checked);
                    colorSelected = "dark blue";
                }
                else if (colorSelected.equals("dark blue")) {
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue_checked);
                }
                else {
                    colorSelected=("dark blue");
                    colorPink.setBackgroundResource(R.drawable.color_pink);
                    colorRed.setBackgroundResource(R.drawable.color_red);
                    colorOrange.setBackgroundResource(R.drawable.color_orange);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow);
                    colorLime.setBackgroundResource(R.drawable.color_lime);
                    colorGreen.setBackgroundResource(R.drawable.color_green);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                    colorTeal.setBackgroundResource(R.drawable.color_teal);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                    colorBlue.setBackgroundResource(R.drawable.color_blue);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue_checked);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                    colorPurple.setBackgroundResource(R.drawable.color_purple);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_dark_blue);
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_dark_blue);
                allCriteriasMet(nextButton);
            }
        });
        colorMagenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta_checked);
                    colorSelected = "magenta";
                }
                else if (colorSelected.equals("magenta")) {
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta_checked);
                }
                else {
                    colorSelected=("magenta");
                    colorPink.setBackgroundResource(R.drawable.color_pink);
                    colorRed.setBackgroundResource(R.drawable.color_red);
                    colorOrange.setBackgroundResource(R.drawable.color_orange);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow);
                    colorLime.setBackgroundResource(R.drawable.color_lime);
                    colorGreen.setBackgroundResource(R.drawable.color_green);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                    colorTeal.setBackgroundResource(R.drawable.color_teal);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                    colorBlue.setBackgroundResource(R.drawable.color_blue);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta_checked);
                    colorPurple.setBackgroundResource(R.drawable.color_purple);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_magenta);
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_magenta);
                allCriteriasMet(nextButton);
            }
        });
        colorPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colorSelected.equals("")) {
                    colorPurple.setBackgroundResource(R.drawable.color_purple_checked);
                    colorSelected = "purple";
                }
                else if (colorSelected.equals("purple")) {
                    colorPurple.setBackgroundResource(R.drawable.color_purple_checked);
                }
                else {
                    colorSelected=("purple");
                    colorPink.setBackgroundResource(R.drawable.color_pink);
                    colorRed.setBackgroundResource(R.drawable.color_red);
                    colorOrange.setBackgroundResource(R.drawable.color_orange);
                    colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                    colorYellow.setBackgroundResource(R.drawable.color_yellow);
                    colorLime.setBackgroundResource(R.drawable.color_lime);
                    colorGreen.setBackgroundResource(R.drawable.color_green);
                    colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                    colorTeal.setBackgroundResource(R.drawable.color_teal);
                    colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                    colorBlue.setBackgroundResource(R.drawable.color_blue);
                    colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                    colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                    colorPurple.setBackgroundResource(R.drawable.color_purple_checked);
                }
                iconChanged = true;
                icon1 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.color_background_purple);
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_purple);
                allCriteriasMet(nextButton);
            }
        });

        iconVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_video);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_video);
                allCriteriasMet(nextButton);
            }
        });
        iconGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_gallery);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_gallery);
                allCriteriasMet(nextButton);
            }
        });
        iconMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_music);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_music);
                allCriteriasMet(nextButton);
            }
        });
        iconExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_explore);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_explore);
                allCriteriasMet(nextButton);
            }
        });
        iconForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_forward);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_forward);
                allCriteriasMet(nextButton);
            }
        });
        iconFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_folder);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_folder);
                allCriteriasMet(nextButton);
            }
        });
        iconShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_share);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_share);
                allCriteriasMet(nextButton);
            }
        });
        iconReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_report);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_report);
                allCriteriasMet(nextButton);
            }
        });
        iconNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_notes);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_notes);
                allCriteriasMet(nextButton);
            }
        });
        iconGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_game);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_game);
                allCriteriasMet(nextButton);
            }
        });
        iconMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_message);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_message);
                allCriteriasMet(nextButton);
            }
        });
        iconForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_forum);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_forum);
                allCriteriasMet(nextButton);
            }
        });
        iconFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_file);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_file);
                allCriteriasMet(nextButton);
            }
        });
        iconEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = true;
                icon2 = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.icon_background_email);
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_email);
                allCriteriasMet(nextButton);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iconChanged) {
                    MainActivity.actionToAdd.setLogo(icon1,icon2);
                }
                MainActivity.actionToAdd.setName(appName);
                MainActivity.shortcutsList.add(MainActivity.actionToAdd);
                finishAffinity();
                openNextScreen();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0 ) {
                    appName = editable.toString();
                    nameEntered = true;
                }
                else {
                    nameEntered = false;
                }
                allCriteriasMet(nextButton);
            }
        });

        clearTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchEditText.getText().clear();
                MainActivity.updateAvailableShortcuts();
            }
        });

        useDefaultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconChanged = false;
                appIcon.setBackground(MainActivity.actionToAdd.getLogo());
                appIcon.setVisibility(View.VISIBLE);
                customIconBack.setVisibility(View.GONE);
                customIconFront.setVisibility(View.GONE);

                colorPink.setBackgroundResource(R.drawable.color_pink);
                colorRed.setBackgroundResource(R.drawable.color_red);
                colorOrange.setBackgroundResource(R.drawable.color_orange);
                colorLightOrange.setBackgroundResource(R.drawable.color_light_orange);
                colorYellow.setBackgroundResource(R.drawable.color_yellow);
                colorLime.setBackgroundResource(R.drawable.color_lime);
                colorGreen.setBackgroundResource(R.drawable.color_green);
                colorDarkGreen.setBackgroundResource(R.drawable.color_dark_green);
                colorTeal.setBackgroundResource(R.drawable.color_teal);
                colorLightBlue.setBackgroundResource(R.drawable.color_light_blue);
                colorBlue.setBackgroundResource(R.drawable.color_blue);
                colorDarkBlue.setBackgroundResource(R.drawable.color_dark_blue);
                colorMagenta.setBackgroundResource(R.drawable.color_magenta);
                colorPurple.setBackgroundResource(R.drawable.color_purple);
            }
        });
    }

    private void openNextScreen() {
        Intent open = new Intent(this, ShortcutHome.class);
        startActivity(open);
    }

    private void allCriteriasMet(ImageButton nextButton) {
        if (nameEntered) {
            nextButton.setBackgroundResource(R.drawable.create_shortcut_button);
            nextButton.setEnabled(true);
        }
        else {
            nextButton.setBackgroundResource(R.drawable.create_shortcut_button_unclicked);
            nextButton.setEnabled(false);
        }
    }
}