package com.aditya.covid19fightback.data.model.national;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NationalTimeStats {

    @SerializedName("cases_time_series")
    private List<NationalTimeData> nationalTimeDataList;

    public List<NationalTimeData> getNationalTimeDataList() {
        return nationalTimeDataList;
    }

    public void setNationalTimeDataList(List<NationalTimeData> nationalTimeDataList) {
        this.nationalTimeDataList = nationalTimeDataList;
    }
}
