package com.example.widgetapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    private ImageView nextButton;

    public ActionsAdapter(@NonNull Context context, @NonNull ArrayList<Action> actions, ImageView nextButton) {
        this.context = context;
        this.actions = actions;
        this.nextButton = nextButton;
    }

    public class ActionViewHolder extends RecyclerView.ViewHolder {
        private TextView actionName;
        private TextView actionDescription;
        private ImageButton checkButton;

        private ImageView phoneNumberBoxBorder;
        private ImageView phoneNumberBoxLine;
        private TextView phoneNumberText;
        private EditText phoneNumberEditText;
        private ImageButton phoneNumberDelete;
        private ImageView actionListBorder;

        public ActionViewHolder(@NonNull View itemView) {
            super(itemView);
            actionName = itemView.findViewById(R.id.shortcut_option_name);
            actionDescription = itemView.findViewById(R.id.shortcut_top_description);
            checkButton = itemView.findViewById(R.id.action_check_button);
            phoneNumberBoxBorder = itemView.findViewById(R.id.phone_number_box_border);
            phoneNumberBoxLine = itemView.findViewById(R.id.phone_number_box_line);
            phoneNumberText = itemView.findViewById(R.id.phone_number_textview);
            phoneNumberEditText = itemView.findViewById(R.id.phone_number_edittext);
            phoneNumberDelete = itemView.findViewById(R.id.phone_number_delete);
            actionListBorder = itemView.findViewById(R.id.shortcut_option_list_border);
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
        holder.phoneNumberEditText.getText().clear();

        if (action.isChecked()) {
            holder.checkButton.setBackgroundResource(R.drawable.radio_button_checked);
            if (action.getName().equals("Message")) {
                holder.phoneNumberBoxBorder.setVisibility(View.VISIBLE);
                holder.phoneNumberBoxLine.setVisibility(View.VISIBLE);
                holder.phoneNumberText.setVisibility(View.VISIBLE);
                holder.phoneNumberEditText.setVisibility(View.VISIBLE);
                holder.phoneNumberDelete.setVisibility(View.VISIBLE);
                holder.actionListBorder.getLayoutParams().height = (int) (152 * (context.getResources().getDisplayMetrics().density) + 0.5f);
            }
        }
        else {
            holder.checkButton.setBackgroundResource(R.drawable.radio_button_unchecked);

            holder.phoneNumberBoxBorder.setVisibility(View.GONE);
            holder.phoneNumberBoxLine.setVisibility(View.GONE);
            holder.phoneNumberText.setVisibility(View.GONE);
            holder.phoneNumberEditText.setVisibility(View.GONE);
            holder.phoneNumberDelete.setVisibility(View.GONE);
            holder.actionListBorder.getLayoutParams().height = (int) (72 * (context.getResources().getDisplayMetrics().density) + 0.5f);

        }

        holder.checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!action.isChecked()) {
                    MainActivity.actionToAdd = action;
                    action.setChecked(true);
                    holder.checkButton.setBackgroundResource(R.drawable.radio_button_checked);
                    nextButton.setClickable(true);
                    nextButton.setBackgroundResource(R.drawable.next_button_checked);

                    if (action.getName().equals("Message")) {
                        holder.phoneNumberBoxBorder.setVisibility(View.VISIBLE);
                        holder.phoneNumberBoxLine.setVisibility(View.VISIBLE);
                        holder.phoneNumberText.setVisibility(View.VISIBLE);
                        holder.phoneNumberEditText.setVisibility(View.VISIBLE);
                        holder.phoneNumberDelete.setVisibility(View.VISIBLE);
                        holder.actionListBorder.getLayoutParams().height = (int) (152 * (context.getResources().getDisplayMetrics().density) + 0.5f);
                    }
                }
                else {
                    action.setChecked(false);
                    holder.checkButton.setBackgroundResource(R.drawable.radio_button_unchecked);
                    nextButton.setClickable(false);
                    nextButton.setBackgroundResource(R.drawable.next_button_unchecked);

                    holder.phoneNumberBoxBorder.setVisibility(View.GONE);
                    holder.phoneNumberBoxLine.setVisibility(View.GONE);
                    holder.phoneNumberText.setVisibility(View.GONE);
                    holder.phoneNumberEditText.setVisibility(View.GONE);
                    holder.phoneNumberDelete.setVisibility(View.GONE);
                    holder.actionListBorder.getLayoutParams().height = (int) (72 * (context.getResources().getDisplayMetrics().density) + 0.5f);

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

        holder.phoneNumberDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.phoneNumberEditText.getText().clear();
            }
        });
    }

    @Override
    public int getItemCount() {
        return actions.size();
    }
}
