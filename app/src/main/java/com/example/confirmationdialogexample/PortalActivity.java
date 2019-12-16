package com.example.confirmationdialogexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;

public class PortalActivity extends AppCompatActivity {
    RadioButton listSegment , gridSegment,topSegment,bottomSegment,oneSegment,twoSegment, threeSegment;
    EditText numberPerAds ;
    Switch headerSwitch ;
    int adsNumber = 1;
    Button createBtn;
    private LinearLayout itemPerLineLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);
        bindViews();
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
        listSegment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    itemPerLineLayout.setVisibility(View.GONE);
                }else {
                    itemPerLineLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        setInitialValue();

    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        if(listSegment.isChecked()){
            intent.putExtra(Constants.IS_LIST,true);
        }else {
            intent.putExtra(Constants.IS_LIST,false);

        }

        if(topSegment.isChecked()){
            intent.putExtra(Constants.IS_BOTTOM,false);
        }else {
            intent.putExtra(Constants.IS_BOTTOM,true);
        }


        if(headerSwitch.isChecked()){
            intent.putExtra(Constants.IS_HEADER_ENABLED,true);
        }else {
            intent.putExtra(Constants.IS_HEADER_ENABLED,false);
        }

        if(oneSegment.isChecked()){
            intent.putExtra(Constants.ITEM_PER_LINE,1);
        }else if(twoSegment.isChecked()){
            intent.putExtra(Constants.ITEM_PER_LINE,2);
        }else {
            intent.putExtra(Constants.ITEM_PER_LINE,3);
        }


        if(!numberPerAds.getText().toString().trim().isEmpty()){
            intent.putExtra(Constants.NUMBER_PER_AD,Integer.valueOf(numberPerAds.getText().toString()));
        }else {
            intent.putExtra(Constants.NUMBER_PER_AD,1);

        }
        startActivity(intent);
    }

    private void bindViews() {
        listSegment = findViewById(R.id.btn_list);
        gridSegment = findViewById(R.id.btn_grid);
        topSegment = findViewById(R.id.btn_top);
        bottomSegment = findViewById(R.id.btn_bottom);
        oneSegment = findViewById(R.id.btn_one);
        twoSegment = findViewById(R.id.btn_two);
        threeSegment = findViewById(R.id.btn_three);
        numberPerAds = findViewById(R.id.et_number_per_ads);
        headerSwitch = findViewById(R.id.swt_header);
        createBtn = findViewById(R.id.btn_create);
        itemPerLineLayout = findViewById(R.id.ll_item_per_line);
    }

    private void setInitialValue(){
        listSegment.setChecked(true);
        headerSwitch.setChecked(true);
        topSegment.setChecked(true);
        oneSegment.setChecked(true);
    }
}
