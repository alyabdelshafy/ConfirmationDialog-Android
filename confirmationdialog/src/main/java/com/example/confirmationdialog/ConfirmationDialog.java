package com.example.confirmationdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

public class ConfirmationDialog extends Dialog implements View.OnClickListener{
    private Context context;
    private ConfirmationDialogInterface confirmationDialogInterface;
    private Button positiveButton,negativeButton;
    private TextView contentTextView,headerTextView;
    private LinearLayout rootView;


    public ConfirmationDialog(@NonNull Context context, @StyleRes int themeResId,
                              ConfirmationDialogInterface confirmationDialogInterface) {
        super(context, themeResId);
        this.context = context;
        this.confirmationDialogInterface = confirmationDialogInterface;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.confirmation_dialog);
        bindViews();
        setListeners();

    }

    private void bindViews() {
        positiveButton = findViewById(R.id.btn_positive);
        negativeButton = findViewById(R.id.btn_negative);
        contentTextView = findViewById(R.id.tv_content);
        rootView = findViewById(R.id.root_view);
        headerTextView = findViewById(R.id.tv_header);

    }

    private void setListeners() {
        positiveButton.setOnClickListener(this);
        negativeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() ==  R.id.btn_positive){
            confirmationDialogInterface.onPositiveClicked();
            dismiss();
        }else if(view.getId() ==  R.id.btn_negative){
            confirmationDialogInterface.onNegativeClicked();
            dismiss();
        }
    }





    public interface ConfirmationDialogInterface {
        void onNegativeClicked();
        void onPositiveClicked();
    }

    @Override
    public void cancel() {
        super.cancel();
    }


    public void setBackGround(Drawable drawable){
        rootView.setBackground(drawable);
    }

    public void setHeaderText(String headerText){
        headerTextView.setText(headerText);
    }


    public void contentText(String content){
        headerTextView.setText(content);
    }

    public void setPositiveButtonText(String text){
        positiveButton.setText(text);
    }

    public void setNegativeButtonText(String text){
        negativeButton.setText(text);
    }


    public void setPositiveButtonBackGround(Drawable drawable){
        positiveButton.setBackground(drawable);
    }


    public void setNegativeButtonBackGround(Drawable drawable){
        negativeButton.setBackground(drawable);
    }
}
