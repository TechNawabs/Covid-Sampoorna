package com.aditya.covid19fightback.data.model.state;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StateData {

    @SerializedName("state")
    private String state;
    @SerializedName("districtData")
    private List<DistrictData> districtData;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<DistrictData> getDistrictData() {
        return districtData;
    }

    public void setDistrictData(List<DistrictData> districtData) {
        this.districtData = districtData;
    }

}
