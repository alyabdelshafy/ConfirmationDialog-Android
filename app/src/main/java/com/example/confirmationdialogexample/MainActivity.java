package com.example.confirmationdialogexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.confirmationdialog.AdModel;
import com.example.confirmationdialog.SpeakolRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int userData = 15;
    int userSpanCount = 4;
    int noOfAds = 13;
    int noOfItemPerRow = 2;
    boolean isHeaderIncluded = true;
    SpeakolRecyclerView.SpeakolType type = SpeakolRecyclerView.SpeakolType.GRID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SpeakolRecyclerView speakolRecyclerView = findViewById(R.id.recycler_view);
        DeveloperAdapter adapter = new DeveloperAdapter(this,getDeveloperFakeData());
        speakolRecyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, userSpanCount);
        speakolRecyclerView.setSpeakolLayoutManager(new LinearLayoutManager(this),adapter.getSpeakolItemCount());
        adapter.onGetAddsSuccess(getAdsFakeData(noOfAds), SpeakolRecyclerView.SpeakolType.GRID,noOfItemPerRow,isHeaderIncluded);
    }


    private ArrayList<String> getDeveloperFakeData(){
        ArrayList<String> developerData = new ArrayList<>();
        for(int i= 0; i<userData; i++){
            developerData.add("");
        }
        return developerData;
    }

    private ArrayList<AdModel> getAdsFakeData(int noOfAds){
        ArrayList<AdModel> developerData = new ArrayList<>();
        for(int i= 0; i<noOfAds; i++){
            developerData.add(new AdModel("",""));
        }
        if(isHeaderIncluded){
            for(int i= 0; i<noOfItemPerRow; i++){
                developerData.add(new AdModel("",""));
            }

        }
        return developerData;
    }
}
