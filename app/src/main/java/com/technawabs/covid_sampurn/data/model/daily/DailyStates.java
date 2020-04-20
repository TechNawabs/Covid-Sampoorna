package com.technawabs.covid_sampurn.data.model.daily;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DailyStates {

    @SerializedName("states_daily")
    private List<DailyData> dailyStates;

    public List<DailyData> getDailyStates() {
        return dailyStates;
    }

    public void setDailyStates(List<DailyData> dailyStates) {
        this.dailyStates = dailyStates;
    }
}
