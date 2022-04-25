package com.example.widgetapp.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.widgetapp.Adapters.HomeAdapter;
import com.example.widgetapp.MainActivity;
import com.example.widgetapp.R;
import com.example.widgetapp.Shortcut;

public class HomeScreen extends AppCompatActivity {

    HomeAdapter HomeAdapter;
    RecyclerView HomeRecyclerView;
    int n = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shortcut_home);

        ImageButton addButton = findViewById(R.id.add_shortcut_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.shortcutsList.add(new Shortcut(view,n));
                n++;
                HomeAdapter.notifyDataSetChanged();
            }
        });

        setupRecyclerView();
    }

    void setupRecyclerView() {
        HomeAdapter = new HomeAdapter(this, MainActivity.shortcutsList);
        HomeRecyclerView = findViewById(R.id.shortcut_list_view);
        HomeRecyclerView.setAdapter(HomeAdapter);
        HomeRecyclerView.setLayoutManager(new GridLayoutManager(this, 4, RecyclerView.VERTICAL, false));
        // new LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        // new GridLayoutManager(this, 4, RecyclerView.HORIZONTAL, false)
    }
}