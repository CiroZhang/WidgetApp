package com.example.widgetapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.widgetapp.R;
import com.example.widgetapp.Shortcut;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ShortcutViewHolder>{

    private Context context;
    private ArrayList<Shortcut> shortcutsList;

    public HomeAdapter(@NonNull Context context, @NonNull ArrayList<Shortcut> shortcutsList) {
        this.context = context;
        this.shortcutsList = shortcutsList;
    }

    public class ShortcutViewHolder extends RecyclerView.ViewHolder {
        private TextView shortcut_name;
        private ConstraintLayout wholeLayout;

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
        Shortcut shortcut = shortcutsList.get(position);
        holder.shortcut_name.setText(shortcut.getName());
        holder.wholeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("HI");
            }
        });
    }

    @Override
    public int getItemCount() {
        return shortcutsList.size();
    }
}
