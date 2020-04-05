package com.aditya.covid19fightback.data.model.travel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TravelStat {

    @SerializedName("travel_history")
    private List<TravelData> travelDataList;

    public List<TravelData> getTravelDataList() {
        return travelDataList;
    }

    public void setTravelDataList(List<TravelData> travelDataList) {
        this.travelDataList = travelDataList;
    }
}
