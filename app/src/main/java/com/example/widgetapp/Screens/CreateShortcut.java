package com.example.widgetapp.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.widgetapp.Adapters.ActionsAdapter;
import com.example.widgetapp.Adapters.HomeAdapter;
import com.example.widgetapp.MainActivity;
import com.example.widgetapp.R;

public class CreateShortcut extends AppCompatActivity {

    ActionsAdapter ActionsAdapter;
    RecyclerView ActionsRecyclerView;
    Activity activity = CreateShortcut.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_shortcut);

        ImageView backButton = findViewById(R.id.back_button);
        ImageView appIcon = findViewById(R.id.apps_icon);
        TextView appName = findViewById(R.id.apps_name);
        ImageButton nextButton = findViewById(R.id.add_shortcut_button);

        appIcon.setBackground(MainActivity.currentShortcut.getLogo());

        appName.setText(MainActivity.currentShortcut.getName());

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.actionToAdd.setInfo(MainActivity.currentInfo);
                openNextScreen();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });

        setupRecyclerView(nextButton);
    }

    private void setupRecyclerView(ImageButton nextButton) {
        ActionsAdapter = new ActionsAdapter(this, MainActivity.shortcutActions, nextButton);
        ActionsRecyclerView = findViewById(R.id.apps_list_view);
        ActionsRecyclerView.setAdapter(ActionsAdapter);
        ActionsRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        // new LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        // new GridLayoutManager(this, 4, RecyclerView.HORIZONTAL, false)
    }

    private void openNextScreen() {
        Intent open = new Intent(this, ShortcutCustomize.class);
        startActivity(open);
    }
}