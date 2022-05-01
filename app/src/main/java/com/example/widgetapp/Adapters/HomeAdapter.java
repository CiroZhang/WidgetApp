package com.example.widgetapp.Adapters;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.widgetapp.Action;
import com.example.widgetapp.R;
import com.example.widgetapp.Shortcut;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ShortcutViewHolder>{

    private Context context;
    private ArrayList<Action> shortcutsList;

    public HomeAdapter(@NonNull Context context, @NonNull ArrayList<Action> shortcutsList) {
        this.context = context;
        this.shortcutsList = shortcutsList;
    }

    public class ShortcutViewHolder extends RecyclerView.ViewHolder {
        private TextView shortcut_name;
        private LinearLayout wholeLayout;

        public ShortcutViewHolder(@NonNull View itemView) {
            super(itemView);
            shortcut_name = itemView.findViewById(R.id.shortcut_name);
            wholeLayout = itemView.findViewById(R.id.shortcut_full_icon);
        }
    }

    @NonNull
    @Override
    public ShortcutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_shortcut, parent, false);
        return new ShortcutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ShortcutViewHolder holder, int position) {
        Action shortcut = shortcutsList.get(position);
        holder.shortcut_name.setText(shortcut.getName());
        holder.wholeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start shortcut activity
            }
        });

        PopupMenu popupMenu = new PopupMenu(context, holder.wholeLayout);
        popupMenu.getMenuInflater().inflate(R.menu.menutest, popupMenu.getMenu());
        popupMenu.setForceShowIcon(true);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menu_item) {
                switch (menu_item.getItemId()) {
                    case R.id.icon_explore:
                    case R.id.icon_forum:
                        break;
                }
                return true;
            }

        });
    }

    @Override
    public int getItemCount() {
        return shortcutsList.size();
    }
}
