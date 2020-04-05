package com.aditya.covid19fightback.data.model.raw;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RawStat {

    @SerializedName("raw_data")
    private List<RawStat> rawStatList;

    public List<RawStat> getRawStatList() {
        return rawStatList;
    }

    public void setRawStatList(List<RawStat> rawStatList) {
        this.rawStatList = rawStatList;
    }
}
