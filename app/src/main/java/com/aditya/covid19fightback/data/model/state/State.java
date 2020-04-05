package com.aditya.covid19fightback.data.model.state;

import java.util.List;

public class State {

    private String state;
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
