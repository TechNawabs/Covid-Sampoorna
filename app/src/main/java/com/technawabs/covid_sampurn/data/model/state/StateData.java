package com.technawabs.covid_sampurn.data.model.state;

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

    public long getDistrictsConfirmedCases() {
        long res = 0;
        if(districtData != null && districtData.size() > 0) {
            for (DistrictData district: districtData) {
                res += district.getConfirmed();
            }
        }
        return res;
    }

}
