package com.example.widgetapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.widgetapp.Action;
import com.example.widgetapp.MainActivity;
import com.example.widgetapp.R;
import com.example.widgetapp.Screens.CreateShortcut;
import com.example.widgetapp.Screens.SelectApps;
import com.example.widgetapp.Shortcut;

import java.util.ArrayList;

public class ActionsAdapter extends RecyclerView.Adapter<ActionsAdapter.ActionViewHolder>{

    private Context context;
    private ArrayList<Action> actions;
    private int lastCheckedPos = -1;

    public ActionsAdapter(@NonNull Context context, @NonNull ArrayList<Action> actions) {
        this.context = context;
        this.actions = actions;
    }

    public class ActionViewHolder extends RecyclerView.ViewHolder {
        private TextView actionName;
        private TextView actionDescription;
        private ImageButton checkButton;

        public ActionViewHolder(@NonNull View itemView) {
            super(itemView);
            actionName = itemView.findViewById(R.id.shortcut_option_name);
            actionDescription = itemView.findViewById(R.id.shortcut_top_description);
            checkButton = itemView.findViewById(R.id.action_check_button);
        }
    }

    @NonNull
    @Override
    public ActionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_apps_shortcut_option, parent, false);
        return new ActionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ActionsAdapter.ActionViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Action action = actions.get(position);
        holder.actionName.setText(action.getName());
        holder.actionDescription.setText(action.getDescription());
        if (action.isChecked()) {
            holder.checkButton.setBackgroundResource(R.drawable.radio_button_checked);
        }
        else {
            holder.checkButton.setBackgroundResource(R.drawable.radio_button_unchecked);
        }
        holder.checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!action.isChecked()) {
                    MainActivity.actionToAdd = action;
                    action.setChecked(true);
                    holder.checkButton.setBackgroundResource(R.drawable.radio_button_checked);
                }
                else {
                    action.setChecked(false);
                    holder.checkButton.setBackgroundResource(R.drawable.radio_button_unchecked);
                }

                int copyOfLastCheckedPosition = lastCheckedPos;
                lastCheckedPos = position;
                if (copyOfLastCheckedPosition != -1 && copyOfLastCheckedPosition != lastCheckedPos) {
                    actions.get(copyOfLastCheckedPosition).setChecked(false);
                }
                notifyItemChanged(copyOfLastCheckedPosition);
                notifyItemChanged(lastCheckedPos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return actions.size();
    }
}
