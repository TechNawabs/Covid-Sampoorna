package com.technawabs.covid_sampurn.data.model.national;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NationalTimeStats {

    @SerializedName("cases_time_series")
    private List<NationalTimeData> nationalTimeDataList;

    @SerializedName("statewise")
    private List<StatewiseData> statewiseDataList;

    @SerializedName("tested")
    private List<TestedData> testedDataList;

    public List<NationalTimeData> getNationalTimeDataList() {
        return nationalTimeDataList;
    }

    public void setNationalTimeDataList(List<NationalTimeData> nationalTimeDataList) {
        this.nationalTimeDataList = nationalTimeDataList;
    }

    public List<StatewiseData> getStatewiseDataList() {
        return statewiseDataList;
    }

    public void setStatewiseDataList(List<StatewiseData> statewiseDataList) {
        this.statewiseDataList = statewiseDataList;
    }

    public List<TestedData> getTestedDataList() {
        return testedDataList;
    }

    public void setTestedDataList(List<TestedData> testedDataList) {
        this.testedDataList = testedDataList;
    }
}
