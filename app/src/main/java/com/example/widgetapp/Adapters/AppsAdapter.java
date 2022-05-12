package com.example.widgetapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.widgetapp.Action;
import com.example.widgetapp.MainActivity;
import com.example.widgetapp.R;
import com.example.widgetapp.Screens.CreateShortcut;
import com.example.widgetapp.Screens.SelectApps;
import com.example.widgetapp.Shortcut;

import java.util.ArrayList;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.AppViewHolder>{

    private Context context;
    private ArrayList<Shortcut> availableShortcuts;

    public AppsAdapter(@NonNull Context context, @NonNull ArrayList<Shortcut> availableShortcuts) {
        this.context = context;
        this.availableShortcuts = availableShortcuts;
    }

    public class AppViewHolder extends RecyclerView.ViewHolder {
        private ImageButton app_icon;
        private TextView app_name;
        private ConstraintLayout layout;

        public AppViewHolder(@NonNull View itemView) {
            super(itemView);
            app_icon = itemView.findViewById(R.id.apps_icon);
            app_name = itemView.findViewById(R.id.apps_name);
            layout = itemView.findViewById(R.id.select_app_layout);
            layout.setClickable(true);
        }
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_apps, parent, false);
        return new AppViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AppsAdapter.AppViewHolder holder, int position) {
        Shortcut shortcut = availableShortcuts.get(position);
        holder.app_name.setText(shortcut.getName());
        holder.app_icon.setBackgroundDrawable(shortcut.getLogo());
//        holder.app_icon.setBackground(ContextCompat.getDrawable(context,R.drawable.messenger_icon));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.updateShortcutActions(shortcut);
                MainActivity.currentShortcut = shortcut;
                openNextScreen();
            }
        });
    }

    @Override
    public int getItemCount() {
        return availableShortcuts.size();
    }

    private void openNextScreen() {
        Intent open = new Intent(context, CreateShortcut.class);
        context.startActivity(open);
    }
}
