package com.example.widgetapp.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_pink);
                allCriteriasMet(nextButton);
            }
        });
        colorRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_red);
                allCriteriasMet(nextButton);
            }
        });
        colorOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_orange);
                allCriteriasMet(nextButton);
            }
        });
        colorLightOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_light_orange);
                allCriteriasMet(nextButton);
            }
        });
        colorYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_yellow);
                allCriteriasMet(nextButton);
            }
        });
        colorLime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_lime);
                allCriteriasMet(nextButton);
            }
        });
        colorGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_green);
                allCriteriasMet(nextButton);
            }
        });
        colorDarkGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_dark_green);
                allCriteriasMet(nextButton);
            }
        });
        colorTeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_teal);
                allCriteriasMet(nextButton);
            }
        });
        colorLightBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_light_blue);
                allCriteriasMet(nextButton);
            }
        });
        colorBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_blue);
                allCriteriasMet(nextButton);
            }
        });
        colorDarkBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_dark_blue);
                allCriteriasMet(nextButton);
            }
        });
        colorMagenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_magenta);
                allCriteriasMet(nextButton);
            }
        });
        colorPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconBack.setVisibility(View.VISIBLE);
                customIconBack.setBackgroundResource(R.drawable.color_background_purple);
                allCriteriasMet(nextButton);
            }
        });

        iconVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_video);
                allCriteriasMet(nextButton);
            }
        });
        iconGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_gallery);
                allCriteriasMet(nextButton);
            }
        });
        iconMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_music);
                allCriteriasMet(nextButton);
            }
        });
        iconExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_explore);
                allCriteriasMet(nextButton);
            }
        });
        iconForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_forward);
                allCriteriasMet(nextButton);
            }
        });
        iconFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_folder);
                allCriteriasMet(nextButton);
            }
        });
        iconShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_share);
                allCriteriasMet(nextButton);
            }
        });
        iconReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_report);
                allCriteriasMet(nextButton);
            }
        });
        iconNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_notes);
                allCriteriasMet(nextButton);
            }
        });
        iconGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_game);
                allCriteriasMet(nextButton);
            }
        });
        iconMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_message);
                allCriteriasMet(nextButton);
            }
        });
        iconForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_forum);
                allCriteriasMet(nextButton);
            }
        });
        iconFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_file);
                allCriteriasMet(nextButton);
            }
        });
        iconEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appIcon.setVisibility(View.INVISIBLE);
                customIconFront.setVisibility(View.VISIBLE);
                customIconFront.setBackgroundResource(R.drawable.icon_background_email);
                allCriteriasMet(nextButton);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                appIcon.setBackground(MainActivity.actionToAdd.getLogo());
                appIcon.setVisibility(View.VISIBLE);
                customIconBack.setVisibility(View.GONE);
                customIconFront.setVisibility(View.GONE);
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