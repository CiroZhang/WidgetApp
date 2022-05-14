package com.example.widgetapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.widgetapp.Action;
import com.example.widgetapp.MainActivity;
import com.example.widgetapp.R;

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
        private ImageView actionListBorder;
        private ConstraintLayout layout;

        private ImageView phoneNumberBoxBorder;
        private ImageView phoneNumberBoxLine;
        private TextView phoneNumberText;
        private EditText phoneNumberEditText;
        private ImageButton phoneNumberDelete;

        private ImageView subjectBoxBorder;
        private ImageView subjectBoxLine;
        private TextView subjectText;
        private EditText subjectEditText;
        private ImageButton subjectDelete;

        private ImageView contentBoxBorder;
        private ImageView contentBoxLine;
        private TextView contentText;
        private EditText contentEditText;
        private ImageButton contentDelete;

        public ActionViewHolder(@NonNull View itemView) {
            super(itemView);
            actionName = itemView.findViewById(R.id.shortcut_option_name);
            actionDescription = itemView.findViewById(R.id.shortcut_top_description);
            checkButton = itemView.findViewById(R.id.action_check_button);
            actionListBorder = itemView.findViewById(R.id.shortcut_option_list_border);
            layout = itemView.findViewById(R.id.shortcut_layout);

            phoneNumberBoxBorder = itemView.findViewById(R.id.phone_number_box_border);
            phoneNumberBoxLine = itemView.findViewById(R.id.phone_number_box_line);
            phoneNumberText = itemView.findViewById(R.id.phone_number_textview);
            phoneNumberEditText = itemView.findViewById(R.id.phone_number_edittext);
            phoneNumberDelete = itemView.findViewById(R.id.phone_number_delete);

            subjectBoxBorder = itemView.findViewById(R.id.subject_box_border);
            subjectBoxLine = itemView.findViewById(R.id.subject_box_line);
            subjectText = itemView.findViewById(R.id.subject_textview);
            subjectEditText = itemView.findViewById(R.id.subject_edittext);
            subjectDelete = itemView.findViewById(R.id.subject_delete);

            contentBoxBorder = itemView.findViewById(R.id.content_box_border);
            contentBoxLine = itemView.findViewById(R.id.content_box_line);
            contentText = itemView.findViewById(R.id.content_textview);
            contentEditText = itemView.findViewById(R.id.content_edittext);
            contentDelete = itemView.findViewById(R.id.content_delete);
        }
    }

    @NonNull
    @Override
    public ActionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_shortcut_action, parent, false);
        return new ActionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ActionsAdapter.ActionViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Action action = actions.get(position);
        holder.actionName.setText(action.getName());
        holder.actionDescription.setText(action.getDescription());

        holder.phoneNumberEditText.getText().clear();
        holder.phoneNumberBoxBorder.setVisibility(View.GONE);
        holder.phoneNumberBoxLine.setVisibility(View.GONE);
        holder.phoneNumberText.setVisibility(View.GONE);
        holder.phoneNumberEditText.setVisibility(View.GONE);
        holder.phoneNumberEditText.setTransformationMethod(null);
        holder.phoneNumberDelete.setVisibility(View.GONE);

        holder.subjectEditText.getText().clear();
        holder.subjectBoxBorder.setVisibility(View.GONE);
        holder.subjectBoxLine.setVisibility(View.GONE);
        holder.subjectText.setVisibility(View.GONE);
        holder.subjectEditText.setVisibility(View.GONE);
        holder.subjectDelete.setVisibility(View.GONE);

        holder.contentEditText.getText().clear();
        holder.contentBoxBorder.setVisibility(View.GONE);
        holder.contentBoxLine.setVisibility(View.GONE);
        holder.contentText.setVisibility(View.GONE);
        holder.contentEditText.setVisibility(View.GONE);
        holder.contentDelete.setVisibility(View.GONE);

        holder.actionListBorder.getLayoutParams().height = (int) (72 * (context.getResources().getDisplayMetrics().density) + 0.5f);

        if (action.isChecked()) {
            holder.checkButton.setBackgroundResource(R.drawable.radio_button_checked);
            if (action.getName().equals("Message...") || action.getName().equals("Call...") || action.getName().equals("Search for a location") || action.getName().equals("Share to WhatsApp") || action.getName().equals("Email...") || action.getName().equals("Search in Facebook") || action.getName().equals("Open a website") || action.getName().equals("Share to Twitter") || action.getName().equals("Search in Twitter")) {
                holder.phoneNumberBoxBorder.setVisibility(View.VISIBLE);
                holder.phoneNumberBoxLine.setVisibility(View.VISIBLE);
                holder.phoneNumberText.setVisibility(View.VISIBLE);
                holder.phoneNumberEditText.setVisibility(View.VISIBLE);
                holder.phoneNumberDelete.setVisibility(View.VISIBLE);

                nextButton.setClickable(false);
                nextButton.setBackgroundResource(R.drawable.next_button_unchecked);

                holder.actionListBorder.getLayoutParams().height = (int) (152 * (context.getResources().getDisplayMetrics().density) + 0.5f);

                if (action.getName().equals("Search for a location")) {
                    holder.phoneNumberText.setText("Location");
                    holder.phoneNumberEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                if (action.getName().equals("Share to WhatsApp")) {
                    holder.phoneNumberText.setText("Message to be shared");
                    holder.phoneNumberEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                if (action.getName().equals("Search in Facebook")) {
                    holder.phoneNumberText.setText("Content to be searched");
                    holder.phoneNumberEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                if (action.getName().equals("Open a website")) {
                    holder.phoneNumberText.setText("URL / Content to be searched");
                    holder.phoneNumberEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                if (action.getName().equals("Share to Twitter")) {
                    holder.phoneNumberText.setText("Content to be shared");
                    holder.phoneNumberEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                if (action.getName().equals("Search in Twitter")) {
                    holder.phoneNumberText.setText("Content to be searched");
                    holder.phoneNumberEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                if (action.getName().equals("Email...")) {
                    holder.phoneNumberText.setText("Receiving address");
                    holder.phoneNumberEditText.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS);

                    holder.subjectBoxBorder.setVisibility(View.VISIBLE);
                    holder.subjectBoxLine.setVisibility(View.VISIBLE);
                    holder.subjectText.setVisibility(View.VISIBLE);
                    holder.subjectEditText.setVisibility(View.VISIBLE);
                    holder.subjectDelete.setVisibility(View.VISIBLE);

                    holder.contentBoxBorder.setVisibility(View.VISIBLE);
                    holder.contentBoxLine.setVisibility(View.VISIBLE);
                    holder.contentText.setVisibility(View.VISIBLE);
                    holder.contentEditText.setVisibility(View.VISIBLE);
                    holder.contentDelete.setVisibility(View.VISIBLE);

                    holder.actionListBorder.getLayoutParams().height = (int) (295 * (context.getResources().getDisplayMetrics().density) + 0.5f);
                }
            }
        }
        else {
            holder.checkButton.setBackgroundResource(R.drawable.radio_button_unchecked);

            holder.phoneNumberBoxBorder.setVisibility(View.GONE);
            holder.phoneNumberBoxLine.setVisibility(View.GONE);
            holder.phoneNumberText.setVisibility(View.GONE);
            holder.phoneNumberEditText.setVisibility(View.GONE);
            holder.phoneNumberDelete.setVisibility(View.GONE);

            holder.subjectEditText.getText().clear();
            holder.subjectBoxBorder.setVisibility(View.GONE);
            holder.subjectBoxLine.setVisibility(View.GONE);
            holder.subjectText.setVisibility(View.GONE);
            holder.subjectEditText.setVisibility(View.GONE);
            holder.subjectDelete.setVisibility(View.GONE);

            holder.contentEditText.getText().clear();
            holder.contentBoxBorder.setVisibility(View.GONE);
            holder.contentBoxLine.setVisibility(View.GONE);
            holder.contentText.setVisibility(View.GONE);
            holder.contentEditText.setVisibility(View.GONE);
            holder.contentDelete.setVisibility(View.GONE);

            holder.actionListBorder.getLayoutParams().height = (int) (72 * (context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!action.isChecked()) {
                    MainActivity.actionToAdd = action;
                    action.setChecked(true);
                    holder.checkButton.setBackgroundResource(R.drawable.radio_button_checked);
                    nextButton.setClickable(true);
                    nextButton.setBackgroundResource(R.drawable.next_button_checked);

                    if (action.getName().equals("Message...") || action.getName().equals("Call...") || action.getName().equals("Search for a location") || action.getName().equals("Share to WhatsApp") || action.getName().equals("Email...") || action.getName().equals("Search in Facebook") || action.getName().equals("Open a website") || action.getName().equals("Share to Twitter") || action.getName().equals("Search in Twitter")) {
                        holder.phoneNumberBoxBorder.setVisibility(View.VISIBLE);
                        holder.phoneNumberBoxLine.setVisibility(View.VISIBLE);
                        holder.phoneNumberText.setVisibility(View.VISIBLE);
                        holder.phoneNumberEditText.setVisibility(View.VISIBLE);
                        holder.phoneNumberDelete.setVisibility(View.VISIBLE);

                        nextButton.setClickable(false);
                        nextButton.setBackgroundResource(R.drawable.next_button_unchecked);

                        holder.actionListBorder.getLayoutParams().height = (int) (152 * (context.getResources().getDisplayMetrics().density) + 0.5f);

                        if (action.getName().equals("Search for a location")) {
                            holder.phoneNumberText.setText("Location");
                            holder.phoneNumberEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                        }

                        if (action.getName().equals("Share to WhatsApp")) {
                            holder.phoneNumberText.setText("Message to be shared");
                            holder.phoneNumberEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                        }

                        if (action.getName().equals("Search in Facebook")) {
                            holder.phoneNumberText.setText("Content to be searched");
                            holder.phoneNumberEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                        }

                        if (action.getName().equals("Open a website")) {
                            holder.phoneNumberText.setText("URL / Content to be searched");
                            holder.phoneNumberEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                        }

                        if (action.getName().equals("Share to Twitter")) {
                            holder.phoneNumberText.setText("Content to be shared");
                            holder.phoneNumberEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                        }

                        if (action.getName().equals("Search in Twitter")) {
                            holder.phoneNumberText.setText("Content to be searched");
                            holder.phoneNumberEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                        }

                        if (action.getName().equals("Email...")) {
                            holder.phoneNumberText.setText("Receiving address");
                            holder.phoneNumberEditText.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS);

                            holder.subjectBoxBorder.setVisibility(View.VISIBLE);
                            holder.subjectBoxLine.setVisibility(View.VISIBLE);
                            holder.subjectText.setVisibility(View.VISIBLE);
                            holder.subjectEditText.setVisibility(View.VISIBLE);
                            holder.subjectDelete.setVisibility(View.VISIBLE);

                            holder.contentBoxBorder.setVisibility(View.VISIBLE);
                            holder.contentBoxLine.setVisibility(View.VISIBLE);
                            holder.contentText.setVisibility(View.VISIBLE);
                            holder.contentEditText.setVisibility(View.VISIBLE);
                            holder.contentDelete.setVisibility(View.VISIBLE);

                            holder.actionListBorder.getLayoutParams().height = (int) (295 * (context.getResources().getDisplayMetrics().density) + 0.5f);
                        }
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

                    holder.subjectBoxBorder.setVisibility(View.GONE);
                    holder.subjectBoxLine.setVisibility(View.GONE);
                    holder.subjectText.setVisibility(View.GONE);
                    holder.subjectEditText.setVisibility(View.GONE);
                    holder.subjectDelete.setVisibility(View.GONE);

                    holder.contentBoxBorder.setVisibility(View.GONE);
                    holder.contentBoxLine.setVisibility(View.GONE);
                    holder.contentText.setVisibility(View.GONE);
                    holder.contentEditText.setVisibility(View.GONE);
                    holder.contentDelete.setVisibility(View.GONE);

                    holder.actionListBorder.getLayoutParams().height = (int) (72 * (context.getResources().getDisplayMetrics().density) + 0.5f);
                }

                holder.phoneNumberBoxBorder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (action.getName().equals("Email...")) {
                            holder.phoneNumberBoxBorder.setVisibility(View.VISIBLE);
                            holder.phoneNumberBoxLine.setVisibility(View.VISIBLE);
                            holder.phoneNumberText.setVisibility(View.VISIBLE);
                            holder.phoneNumberEditText.setVisibility(View.VISIBLE);
                            holder.phoneNumberDelete.setVisibility(View.VISIBLE);

                            holder.subjectBoxBorder.setVisibility(View.VISIBLE);
                            holder.subjectBoxLine.setVisibility(View.VISIBLE);
                            holder.subjectText.setVisibility(View.VISIBLE);
                            holder.subjectEditText.setVisibility(View.VISIBLE);
                            holder.subjectDelete.setVisibility(View.VISIBLE);

                            holder.contentBoxBorder.setVisibility(View.VISIBLE);
                            holder.contentBoxLine.setVisibility(View.VISIBLE);
                            holder.contentText.setVisibility(View.VISIBLE);
                            holder.contentEditText.setVisibility(View.VISIBLE);
                            holder.contentDelete.setVisibility(View.VISIBLE);

                            holder.actionListBorder.getLayoutParams().height = (int) (295 * (context.getResources().getDisplayMetrics().density) + 0.5f);
                        }
                        else {
                            holder.phoneNumberBoxBorder.setVisibility(View.VISIBLE);
                            holder.phoneNumberBoxLine.setVisibility(View.VISIBLE);
                            holder.phoneNumberText.setVisibility(View.VISIBLE);
                            holder.phoneNumberEditText.setVisibility(View.VISIBLE);
                            holder.phoneNumberDelete.setVisibility(View.VISIBLE);
                            holder.actionListBorder.getLayoutParams().height = (int) (152 * (context.getResources().getDisplayMetrics().density) + 0.5f);
                        }
                    }
                });

                holder.subjectBoxBorder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.phoneNumberBoxBorder.setVisibility(View.VISIBLE);
                        holder.phoneNumberBoxLine.setVisibility(View.VISIBLE);
                        holder.phoneNumberText.setVisibility(View.VISIBLE);
                        holder.phoneNumberEditText.setVisibility(View.VISIBLE);
                        holder.phoneNumberDelete.setVisibility(View.VISIBLE);

                        holder.subjectBoxBorder.setVisibility(View.VISIBLE);
                        holder.subjectBoxLine.setVisibility(View.VISIBLE);
                        holder.subjectText.setVisibility(View.VISIBLE);
                        holder.subjectEditText.setVisibility(View.VISIBLE);
                        holder.subjectDelete.setVisibility(View.VISIBLE);

                        holder.contentBoxBorder.setVisibility(View.VISIBLE);
                        holder.contentBoxLine.setVisibility(View.VISIBLE);
                        holder.contentText.setVisibility(View.VISIBLE);
                        holder.contentEditText.setVisibility(View.VISIBLE);
                        holder.contentDelete.setVisibility(View.VISIBLE);

                        holder.actionListBorder.getLayoutParams().height = (int) (295 * (context.getResources().getDisplayMetrics().density) + 0.5f);
                    }
                });

                holder.contentBoxBorder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.phoneNumberBoxBorder.setVisibility(View.VISIBLE);
                        holder.phoneNumberBoxLine.setVisibility(View.VISIBLE);
                        holder.phoneNumberText.setVisibility(View.VISIBLE);
                        holder.phoneNumberEditText.setVisibility(View.VISIBLE);
                        holder.phoneNumberDelete.setVisibility(View.VISIBLE);

                        holder.subjectBoxBorder.setVisibility(View.VISIBLE);
                        holder.subjectBoxLine.setVisibility(View.VISIBLE);
                        holder.subjectText.setVisibility(View.VISIBLE);
                        holder.subjectEditText.setVisibility(View.VISIBLE);
                        holder.subjectDelete.setVisibility(View.VISIBLE);

                        holder.contentBoxBorder.setVisibility(View.VISIBLE);
                        holder.contentBoxLine.setVisibility(View.VISIBLE);
                        holder.contentText.setVisibility(View.VISIBLE);
                        holder.contentEditText.setVisibility(View.VISIBLE);
                        holder.contentDelete.setVisibility(View.VISIBLE);

                        holder.actionListBorder.getLayoutParams().height = (int) (295 * (context.getResources().getDisplayMetrics().density) + 0.5f);
                    }
                });

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

        holder.subjectDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.subjectEditText.getText().clear();
            }
        });

        holder.contentDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.contentEditText.getText().clear();
            }
        });

        holder.phoneNumberEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty()) {
                    MainActivity.currentInfo.set(0,editable.toString());
                    nextButton.setClickable(true);
                    nextButton.setBackgroundResource(R.drawable.next_button_checked);
                }
                else {
                    nextButton.setClickable(false);
                    nextButton.setBackgroundResource(R.drawable.next_button_unchecked);
                }
            }
        });

        holder.subjectEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                MainActivity.currentInfo.set(1,editable.toString());
            }
        });

        holder.contentEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                MainActivity.currentInfo.set(2,editable.toString());
                System.out.println("address: " + MainActivity.currentInfo.get(0) + "\nsubject: " + MainActivity.currentInfo.get(1) + "\ncontent: " + MainActivity.currentInfo.get(2));
            }
        });
    }

    @Override
    public int getItemCount() {
        return actions.size();
    }
}
