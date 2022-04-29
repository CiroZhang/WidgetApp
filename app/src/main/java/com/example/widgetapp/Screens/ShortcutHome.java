package com.example.widgetapp.Screens;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.example.widgetapp.Adapters.HomeAdapter;
import com.example.widgetapp.MainActivity;
import com.example.widgetapp.R;
import com.example.widgetapp.Shortcut;

import java.util.ArrayList;

public class ShortcutHome extends AppCompatActivity {

    HomeAdapter HomeAdapter;
    RecyclerView HomeRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shortcut_home);

        ImageButton addButton = findViewById(R.id.add_shortcut_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNextScreen();
            }
        });

        setupRecyclerView();
        ArrayList<String> data;

        Shortcut messenger = new Shortcut("Messenger", "Message");
        Shortcut whatsapp = new Shortcut("Share WhatsApp", "ShareWhatsApp");
        Shortcut zoom = new Shortcut("Zoom","none");
        Shortcut googleduo = new Shortcut("GoogleMap", "SearchGoogleMaps");
        Shortcut wechat = new Shortcut("WeChat","none");
        Shortcut twitter = new Shortcut("Share Twitter", "ShareTwitter");

        MainActivity.availableShortcuts.add(messenger);
        MainActivity.availableShortcuts.add(whatsapp);
        MainActivity.availableShortcuts.add(zoom);
        MainActivity.availableShortcuts.add(googleduo);
        MainActivity.availableShortcuts.add(wechat);
        MainActivity.availableShortcuts.add(twitter);
    }

    private void setupRecyclerView() {
        HomeAdapter = new HomeAdapter(this, MainActivity.shortcutsList);
        HomeRecyclerView = findViewById(R.id.shortcut_list_view);
        HomeRecyclerView.setAdapter(HomeAdapter);
        HomeRecyclerView.setLayoutManager(new GridLayoutManager(this, 4, RecyclerView.VERTICAL, false));
        // new LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        // new GridLayoutManager(this, 4, RecyclerView.HORIZONTAL, false)
    }

    private void openNextScreen() {
        Intent open = new Intent(this, SelectApps.class);
        startActivity(open);
    }
}