package com.example.confirmationdialogexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.confirmationdialog.AdModel;
import com.example.confirmationdialog.SpeakolRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int userData = 4;
    int userSpanCount = 3;
    int noOfAds = 13;
    int noOfItemPerRow = 2;
    boolean isHeaderIncluded = false;
    boolean isBottom = true;
    boolean isList = true;
    SpeakolRecyclerView.SpeakolType type = SpeakolRecyclerView.SpeakolType.GRID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkIntent();
        SpeakolRecyclerView speakolRecyclerView = findViewById(R.id.recycler_view);
        DeveloperAdapter adapter = new DeveloperAdapter(this,getDeveloperFakeData());
        speakolRecyclerView.setAdapter(adapter);

        if(isList){
            adapter.onGetAddsSuccess(getAdsFakeData(noOfAds), SpeakolRecyclerView.SpeakolType.LIST,noOfItemPerRow,isHeaderIncluded,isBottom);
            speakolRecyclerView.setSpeakolLayoutManager(new LinearLayoutManager(this),adapter.getSpeakolItemCount(),isBottom);
        }else {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, userSpanCount);
            speakolRecyclerView.setSpeakolLayoutManager(gridLayoutManager,adapter.getSpeakolItemCount(),isBottom);
            adapter.onGetAddsSuccess(getAdsFakeData(noOfAds), SpeakolRecyclerView.SpeakolType.GRID,noOfItemPerRow,isHeaderIncluded,isBottom);
        }
    }

    private void checkIntent() {
        noOfAds = getIntent().getIntExtra(Constants.NUMBER_PER_AD,1);
        noOfItemPerRow = getIntent().getIntExtra(Constants.ITEM_PER_LINE,1);
        isBottom = getIntent().getBooleanExtra(Constants.IS_BOTTOM,true);
        isList = getIntent().getBooleanExtra(Constants.IS_LIST,true);
        isHeaderIncluded = getIntent().getBooleanExtra(Constants.IS_HEADER_ENABLED,true);
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
