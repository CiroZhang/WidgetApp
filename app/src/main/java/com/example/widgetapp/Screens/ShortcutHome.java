package com.example.widgetapp.Screens;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.example.widgetapp.Action;
import com.example.widgetapp.Adapters.HomeAdapter;
import com.example.widgetapp.MainActivity;
import com.example.widgetapp.R;
import com.example.widgetapp.Shortcut;

import java.util.ArrayList;
import java.util.Arrays;

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
    }

    private void setupRecyclerView() {
        HomeAdapter = new HomeAdapter(this, MainActivity.shortcutsList);
        HomeRecyclerView = findViewById(R.id.shortcut_list_view);
        HomeRecyclerView.setAdapter(HomeAdapter);
        HomeRecyclerView.setLayoutManager(new GridLayoutManager(this, 4, RecyclerView.VERTICAL, false));

        MainActivity.availableShortcuts.clear();
        Shortcut messenger = new Shortcut("Messenger", "Message", new ArrayList<>(Arrays.asList(new Action("Message...","Open messages with a specific person",ContextCompat.getDrawable(this,R.drawable.messenger_icon),new Shortcut("Messenger","Message")), new Action("Open App","Open the Messenger App",ContextCompat.getDrawable(this,R.drawable.messenger_icon), new Shortcut("Messenger","OpenApp")))), ContextCompat.getDrawable(this,R.drawable.messenger_icon));
        Shortcut email = new Shortcut("Email","Email", new ArrayList<>(Arrays.asList(new Action("Email...","Email to an address",ContextCompat.getDrawable(this,R.drawable.email_icon),new Shortcut("Email","Email")))),ContextCompat.getDrawable(this,R.drawable.email_icon));
        Shortcut whatsapp = new Shortcut("WhatsApp", "ShareWhatsApp", new ArrayList<>(Arrays.asList(new Action("Share to WhatsApp","Share to a specific person in WhatsApp",ContextCompat.getDrawable(this,R.drawable.whatsapp_icon),new Shortcut("WhatsApp","ShareWhatsapp")), new Action("Open WhatsApp","Open the WhatsApp App",ContextCompat.getDrawable(this,R.drawable.whatsapp_icon),new Shortcut("WhatsApp","OpenWhatsapp")))), ContextCompat.getDrawable(this,R.drawable.whatsapp_icon));
        Shortcut zoom = new Shortcut("Zoom","none", new ArrayList<>(Arrays.asList(new Action("Join Zoom Meeting","Join a Zoom meeting through a code",ContextCompat.getDrawable(this,R.drawable.zoom_icon),new Shortcut("Zoom","JoinZoom")), new Action("Schedule a Zoom meeting","Schedule a Zoom meeting at a specific time",ContextCompat.getDrawable(this,R.drawable.zoom_icon),new Shortcut("Zoom","ScheduleZoom")), new Action("Open Zoom","Open the Zoom App",ContextCompat.getDrawable(this,R.drawable.zoom_icon),new Shortcut("Zoom","OpenZoom")))), ContextCompat.getDrawable(this,R.drawable.zoom_icon));
        Shortcut googlemaps = new Shortcut("Google Maps", "SearchGoogleMaps", new ArrayList<>(Arrays.asList(new Action("Search for a location","Search for a location in the Google Maps App",ContextCompat.getDrawable(this,R.drawable.youtube_icon),new Shortcut("GoogleMaps","SearchGoogleMaps")))), ContextCompat.getDrawable(this,R.drawable.youtube_icon));
//        Shortcut wechat = new Shortcut("WeChat","none", new ArrayList<>(),ContextCompat.getDrawable(this,R.drawable.wechat_icon));
        Shortcut twitter = new Shortcut("Twitter", "ShareTwitter", new ArrayList<>(Arrays.asList(new Action("Share to Twitter","Share to the Twitter App",ContextCompat.getDrawable(this,R.drawable.youtube_icon),new Shortcut("Twitter","ShareTwitter")), new Action("Search in Twitter","Search items using the Twitter App",ContextCompat.getDrawable(this,R.drawable.youtube_icon),new Shortcut("Twitter","SearchTwitter")), new Action("Open Twitter","Open the Twitter App",ContextCompat.getDrawable(this,R.drawable.youtube_icon),new Shortcut("Twitter","OpenTwitter")))), ContextCompat.getDrawable(this,R.drawable.youtube_icon));
        Shortcut phone = new Shortcut("Phone","Call", new ArrayList<>(Arrays.asList(new Action("Call...","Call a specific phone number",ContextCompat.getDrawable(this,R.drawable.phone_icon),new Shortcut("Call","Call")))), ContextCompat.getDrawable(this,R.drawable.phone_icon));
        Shortcut website = new Shortcut("Website","OpenWeb", new ArrayList<>(Arrays.asList(new Action("Open a website","Open a website using a specific URL",ContextCompat.getDrawable(this,R.drawable.youtube_icon),new Shortcut("Website","OpenWeb")))), ContextCompat.getDrawable(this,R.drawable.youtube_icon));
        Shortcut facebook = new Shortcut("Facebook","facebook", new ArrayList<>(Arrays.asList(new Action("Share to Facebook","Share to the Facebook App",ContextCompat.getDrawable(this,R.drawable.facebook_icon),new Shortcut("Facebook","ShareFacebook")), new Action("Send to Facebook","Send a message to a Facebook user",ContextCompat.getDrawable(this,R.drawable.facebook_icon),new Shortcut("Facebook","SendFacebook")), new Action("Search in Facebook","Search for items in the Facebook App",ContextCompat.getDrawable(this,R.drawable.facebook_icon),new Shortcut("Facebook","SearchFacebook")), new Action("Open Facebook","Open the Facebook App",ContextCompat.getDrawable(this,R.drawable.facebook_icon),new Shortcut("Facebook","OpenFacebook")))), ContextCompat.getDrawable(this,R.drawable.facebook_icon));

        MainActivity.availableShortcuts.add(email);
        MainActivity.availableShortcuts.add(facebook);
        MainActivity.availableShortcuts.add(googlemaps);
        MainActivity.availableShortcuts.add(messenger);
        MainActivity.availableShortcuts.add(whatsapp);
        MainActivity.availableShortcuts.add(phone);
        MainActivity.availableShortcuts.add(twitter);
        MainActivity.availableShortcuts.add(website);
        MainActivity.availableShortcuts.add(zoom);

        // new LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        // new GridLayoutManager(this, 4, RecyclerView.HORIZONTAL, false)
    }

    private void openNextScreen() {
        Intent open = new Intent(this, SelectApps.class);
        startActivity(open);
    }
}