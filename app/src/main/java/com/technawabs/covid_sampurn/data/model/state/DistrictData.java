package com.technawabs.covid_sampurn.data.model.state;

import com.google.gson.annotations.SerializedName;

public class DistrictData {

    @SerializedName("district")
    private String district;
    @SerializedName("confirmed")
    private long confirmed;
    @SerializedName("lastupdatedtime")
    private String lastUpdatedTime;
    @SerializedName("delta")
    private Delta delta;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public long getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(long confirmed) {
        this.confirmed = confirmed;
    }

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public Delta getDelta() {
        return delta;
    }

    public void setDelta(Delta delta) {
        this.delta = delta;
    }
}
