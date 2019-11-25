package com.example.confirmationdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

public class ConfirmationDialog extends Dialog implements View.OnClickListener{
    private Context context;
    private ConfirmationDialogInterface confirmationDialogInterface;
    private Button positiveButton,negativeButton;
    private TextView contentTextView;


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
}
