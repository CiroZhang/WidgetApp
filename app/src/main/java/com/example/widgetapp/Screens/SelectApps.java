package com.example.widgetapp.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.widgetapp.Adapters.AppsAdapter;
import com.example.widgetapp.Adapters.HomeAdapter;
import com.example.widgetapp.MainActivity;
import com.example.widgetapp.R;
import com.example.widgetapp.Shortcut;

import java.util.ArrayList;
import java.util.Locale;

public class SelectApps extends AppCompatActivity {

    AppsAdapter AppsAdapter;
    RecyclerView AppsRecyclerView;
    Activity activity = SelectApps.this;
    String enteredSearchText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_apps);

        ImageView backButton = findViewById(R.id.back_button);
        EditText searchTextField = findViewById(R.id.search_edit_text);
        ImageButton clearTextButton = findViewById(R.id.clear_text_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });

        searchTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    enteredSearchText = editable.toString().toLowerCase();
                }
                else {
                    enteredSearchText = "";
                }

                if (enteredSearchText.isEmpty() || editable.length() == 0 || enteredSearchText.matches("") || enteredSearchText == null) {
                    MainActivity.updateAvailableShortcuts();
                }
                else {
                    MainActivity.updatedSearchShortcuts.clear();
                    for (Shortcut shortcut : MainActivity.availableShortcuts) {
                        if (shortcut.getName().toLowerCase().contains(enteredSearchText)) {
                            MainActivity.updatedSearchShortcuts.add(shortcut);
                        }
                    }
                }
                AppsAdapter.notifyDataSetChanged();
            }
        });

        clearTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchTextField.getText().clear();
                MainActivity.updateAvailableShortcuts();
                AppsAdapter.notifyDataSetChanged();
                System.out.println(MainActivity.updatedSearchShortcuts.size());
            }
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        MainActivity.updateAvailableShortcuts();
        AppsAdapter = new AppsAdapter(this, MainActivity.updatedSearchShortcuts);
        AppsRecyclerView = findViewById(R.id.apps_list_view);
        AppsRecyclerView.setAdapter(AppsAdapter);
        AppsRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        // new LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        // new GridLayoutManager(this, 4, RecyclerView.HORIZONTAL, false)
    }
}