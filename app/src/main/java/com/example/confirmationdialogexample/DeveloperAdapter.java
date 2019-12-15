package com.example.confirmationdialogexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.confirmationdialog.SpeakolAdapter;
import com.example.confirmationdialog.SpeakolViewHolder;

import java.util.ArrayList;

public class DeveloperAdapter extends SpeakolAdapter<SpeakolViewHolder> {

    private ArrayList<String> mediaObjects;


    public DeveloperAdapter(Context context, ArrayList<String> mediaObjects) {
        super(context, mediaObjects.size());
        super.count = mediaObjects.size();
        this.mediaObjects = mediaObjects;
    }

    @Override
    public RecyclerView.ViewHolder onCreateSpeakolViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i<mediaObjects.size()){
            return new DeveloperViewHolder(
                    LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_developer_test, viewGroup, false));
        }else {
            return super.onCreateViewHolder(viewGroup,i);
        }

    }

    @Override
    public void onBindSpeakolViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    }

    @Override
    public int getSpeakolItemCount() {
        return mediaObjects.size();
    }

    @Override
    public int getSpeakolItemType(int position) {
        return 0;
    }


}














