package com.example.confirmationdialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdsViewHolder extends RecyclerView.ViewHolder {

    private LinearLayout ad1LinearLayout, ad2LinearLayout, ad3LinearLayout;
    private SpeakolRecyclerView.SpeakolType type;

    public AdsViewHolder(@NonNull View itemView) {
        super(itemView);
        ad1LinearLayout = itemView.findViewById(R.id.layout_ad_1);
        ad2LinearLayout = itemView.findViewById(R.id.layout_ad_2);
        ad3LinearLayout = itemView.findViewById(R.id.layout_ad_3);

    }

    private void onBindOneItemPerRow(AdModel adModel) {
        ad1LinearLayout.setVisibility(View.VISIBLE);
        ad2LinearLayout.setVisibility(View.INVISIBLE);
        ad3LinearLayout.setVisibility(View.INVISIBLE);
    }

    private void onBindTwoItemPerRow(ArrayList<AdModel> adModelArrayList) {
        ad1LinearLayout.setVisibility(View.VISIBLE);
        ad2LinearLayout.setVisibility(View.VISIBLE);
        ad3LinearLayout.setVisibility(View.GONE);
        if (adModelArrayList.size() > 0) {
            ad1LinearLayout.setVisibility(View.VISIBLE);
        } else {
            ad1LinearLayout.setVisibility(View.GONE);
        }
        if (adModelArrayList.size() > 1) {
            ad2LinearLayout.setVisibility(View.VISIBLE);
        } else {
            ad2LinearLayout.setVisibility(View.INVISIBLE);
        }
    }

    private void onBindThreeItemPerRow(ArrayList<AdModel> adModelArrayList) {
        ad1LinearLayout.setVisibility(View.VISIBLE);
        ad2LinearLayout.setVisibility(View.VISIBLE);
        ad3LinearLayout.setVisibility(View.VISIBLE);

        if (adModelArrayList.size() > 0) {
            ad1LinearLayout.setVisibility(View.VISIBLE);
        } else {
            ad1LinearLayout.setVisibility(View.GONE);
        }

        if (adModelArrayList.size() > 1) {
            ad2LinearLayout.setVisibility(View.VISIBLE);
        } else {
            ad2LinearLayout.setVisibility(View.INVISIBLE);
        }

        if (adModelArrayList.size() > 2) {
            ad3LinearLayout.setVisibility(View.VISIBLE);
        } else {
            ad3LinearLayout.setVisibility(View.INVISIBLE);
        }


    }


    private void onBindListItem(AdModel adModel) {
        ad1LinearLayout.setVisibility(View.VISIBLE);
        ad2LinearLayout.setVisibility(View.GONE);
        ad3LinearLayout.setVisibility(View.GONE);
    }


    public void setData(ArrayList<AdModel> adModelArrayList, SpeakolRecyclerView.SpeakolType type, int noOfItemPerRow) {
        if (type.equals(SpeakolRecyclerView.SpeakolType.LIST)) {
            onBindListItem(adModelArrayList.get(0));
        } else {
            switch (noOfItemPerRow) {
                case 1:
                    onBindOneItemPerRow(adModelArrayList.get(0));
                    break;
                case 2:
                    onBindTwoItemPerRow(adModelArrayList);
                    break;
                case 3:
                    onBindThreeItemPerRow(adModelArrayList);
                    break;
            }
        }
    }


}
