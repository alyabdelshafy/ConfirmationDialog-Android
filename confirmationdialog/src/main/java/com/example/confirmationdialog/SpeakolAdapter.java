package com.example.confirmationdialog;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.HeaderViewListAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class SpeakolAdapter<S> extends RecyclerView.Adapter {
    public int count = 0;
    private Context context;

    private int speakolType = 76687666;
    private int speakolHeader = 28723872;

    private int noOfItemsPerRow = 1;
    private ArrayList<AdModel> adModelArrayList;
    private SpeakolRecyclerView.SpeakolType type = SpeakolRecyclerView.SpeakolType.LIST;
    private HashMap<Integer, ArrayList<AdModel>> speakolGridHashMap;
    private HashMap<Integer, AdModel> speakolListHashMap;

    private boolean isHeaderIncluded = true;


    public SpeakolAdapter(Context context, int count) {
        this.context = context;
        this.count = count;
        this.adModelArrayList = new ArrayList<>();
        speakolGridHashMap = new HashMap<>();
        speakolListHashMap = new HashMap<>();

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        if (type == speakolType) {
            return new AdsViewHolder(
                    LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ads, viewGroup, false));
        }else if(type == speakolHeader){
            return new SpeakolHeaderViewHolder(
                    LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_header, viewGroup, false));
        }else {
            return onCreateSpeakolViewHolder(viewGroup, type);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if(position == getSpeakolItemCount() && isHeaderIncluded){

        }else if (position >= getSpeakolItemCount()) {
            AdsViewHolder adsViewHolder = (AdsViewHolder) viewHolder;
            if (type.equals(SpeakolRecyclerView.SpeakolType.LIST)) {
                ArrayList<AdModel> adModel = new ArrayList<>();
                adModel.add(adModelArrayList.get(position - getSpeakolItemCount()));
                adsViewHolder.setData(adModel, type, 1);
            } else {
                int adPosition = position - getSpeakolItemCount();
                if(speakolGridHashMap.containsKey(adPosition)){
                    adsViewHolder.setData(speakolGridHashMap.get(adPosition), type, noOfItemsPerRow);
                }
            }
        }else {
            onBindSpeakolViewHolder(viewHolder, position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= getSpeakolItemCount() ) {
            if(isHeaderIncluded){
                if(position == getSpeakolItemCount()){
                    return speakolHeader;
                }
            }
            return speakolType;
        } else {
            return getSpeakolItemType(position);
        }
    }

    @Override
    public int getItemCount() {
        double noOfRows = adModelArrayList.size() /(double) noOfItemsPerRow;
        return getSpeakolItemCount() + (int) Math.ceil(noOfRows) ;

    }

    public SpeakolAdapter() {
        super();
    }


    public abstract RecyclerView.ViewHolder onCreateSpeakolViewHolder(@NonNull ViewGroup viewGroup, int i);

    public abstract void onBindSpeakolViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i);

    public abstract int getSpeakolItemCount();

    public abstract int getSpeakolItemType(int position);

    public void onGetAddsSuccess(ArrayList<AdModel> adModelArrayList,
                                 SpeakolRecyclerView.SpeakolType type,
                                 int noOfItem,
                                 boolean isHeaderIncluded) {
        if (type.equals(SpeakolRecyclerView.SpeakolType.GRID)) {
            this.type = SpeakolRecyclerView.SpeakolType.GRID;
        } else {
            this.type = SpeakolRecyclerView.SpeakolType.LIST;
        }
        this.adModelArrayList = adModelArrayList;
        this.noOfItemsPerRow = noOfItem;
        this.isHeaderIncluded = isHeaderIncluded;
        setSpeakolHashMap();
        notifyDataSetChanged();
    }



    public void setSpeakolHashMap() {
        if (type == SpeakolRecyclerView.SpeakolType.LIST) {
            for (int i = 0; i < adModelArrayList.size(); i++) {
                speakolListHashMap.put(i, adModelArrayList.get(i));
            }
        } else {
            if (noOfItemsPerRow == 1) {
                for (int i = 0; i < adModelArrayList.size(); i++) {
                    ArrayList<AdModel> oneItemArrayList = new ArrayList<>();
                    oneItemArrayList.add(adModelArrayList.get(0));
                    speakolGridHashMap.put(i, oneItemArrayList);
                }
            } else if (noOfItemsPerRow == 2) {
                int position = 0;
                for (int i = 0; i < adModelArrayList.size(); i += 2) {
                    ArrayList<AdModel> itemPerRow = new ArrayList<>();
                    itemPerRow.add(adModelArrayList.get(i));
                    if (i + 1 < adModelArrayList.size()) {
                        itemPerRow.add(adModelArrayList.get(i + 1));
                    }
                    speakolGridHashMap.put(position, itemPerRow);
                    position++;
                }
            } else {
                int position = 0;
                for (int i = 0; i < adModelArrayList.size(); i += 3) {
                    ArrayList<AdModel> itemPerRow = new ArrayList<>();
                    itemPerRow.add(adModelArrayList.get(i));
                    if (i + 1 < adModelArrayList.size()) {
                        itemPerRow.add(adModelArrayList.get(i + 1));
                    }
                    if (i + 2 < adModelArrayList.size()) {
                        itemPerRow.add(adModelArrayList.get(i + 2));
                    }
                    speakolGridHashMap.put(position, itemPerRow);
                    position++;
                }
            }
        }
    }


}
