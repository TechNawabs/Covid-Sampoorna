package com.technawabs.covid_sampurn.data.model.raw;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RawStat {

    @SerializedName("raw_data")
    private List<RawData> rawStatList;

    public List<RawData> getRawStatList() {
        return rawStatList;
    }

    public void setRawStatList(List<RawData> rawStatList) {
        this.rawStatList = rawStatList;
    }
}
