package com.example.widgetapp.Adapters;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        private ImageView shortcut_icon;
        private LinearLayout wholeLayout;

        public ShortcutViewHolder(@NonNull View itemView) {
            super(itemView);
            shortcut_name = itemView.findViewById(R.id.shortcut_name);
            shortcut_icon = itemView.findViewById(R.id.shortcut_icon);
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
        holder.shortcut_icon.setBackground(shortcut.getLogo());
        holder.wholeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, view);
                popupMenu.getMenuInflater().inflate(R.menu.menutest, popupMenu.getMenu());
                popupMenu.setForceShowIcon(true);
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_1:
                                System.out.println("test 1 clicked");
                                return true;
                            case R.id.item_2:
                                System.out.println("test 2 clicked");
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return shortcutsList.size();
    }
}
