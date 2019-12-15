package com.example.confirmationdialogexample;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.confirmationdialog.SpeakolViewHolder;

public class DeveloperViewHolder extends SpeakolViewHolder {
    TextView title;
    View parent;
    public DeveloperViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        title = itemView.findViewById(R.id.title);

    }

    public void onBind() {

    }

}
