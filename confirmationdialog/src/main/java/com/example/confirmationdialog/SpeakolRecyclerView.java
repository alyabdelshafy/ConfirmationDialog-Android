package com.example.confirmationdialog;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SpeakolRecyclerView extends RecyclerView {
    public SpeakolType speakolType;
    public GridLayoutManager gridLayoutManager;
    public Context context;
    public int totalCount = 0;
    public SpeakolRecyclerView(@NonNull Context context) {
        super(context);
        this.context = context;
        gridLayoutManager = new GridLayoutManager(context, 1);
    }

    public SpeakolRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SpeakolRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public void setLayoutManager(@Nullable LayoutManager layout) {
        super.setLayoutManager(layout);
        if(layout instanceof GridLayoutManager){
            GridLayoutManager gridLayoutManager = ((GridLayoutManager)layout);
            final int spanCount = gridLayoutManager.getSpanCount();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if(position >= totalCount){
                        return spanCount;
                    }else {
                        return 1;
                    }
                }
            });
        }
    }


    @Override
    public void setAdapter(@Nullable Adapter adapter) {
        super.setAdapter(adapter);
    }

    public void setSpeakolLayoutManager(LayoutManager layout, int totalCount){
        this.totalCount = totalCount;
        setLayoutManager(layout);
    }

    public enum SpeakolType{
        GRID,LIST
    }
}