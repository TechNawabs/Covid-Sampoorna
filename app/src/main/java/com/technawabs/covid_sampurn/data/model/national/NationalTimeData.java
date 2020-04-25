package com.technawabs.covid_sampurn.data.model.national;

import com.google.gson.annotations.SerializedName;

public class NationalTimeData implements Comparable<NationalTimeData> {

    @SerializedName("dailyconfirmed")
    public String dailyConfirmed;
    @SerializedName("dailydeceased")
    public String dailyDeceased;
    @SerializedName("dailyrecovered")
    public String dailyRecovered;
    @SerializedName("date")
    public String date;
    @SerializedName("totalconfirmed")
    public String totalConfirmed;
    @SerializedName("totaldeceased")
    public String totalDeceased;
    @SerializedName("totalrecovered")
    public String totalRecovered;

    public String getDailyConfirmed() {
        return dailyConfirmed;
    }

    public void setDailyConfirmed(String dailyConfirmed) {
        this.dailyConfirmed = dailyConfirmed;
    }

    public String getDailyDeceased() {
        return dailyDeceased;
    }

    public void setDailyDeceased(String dailyDeceased) {
        this.dailyDeceased = dailyDeceased;
    }

    public String getDailyRecovered() {
        return dailyRecovered;
    }

    public void setDailyRecovered(String dailyRecovered) {
        this.dailyRecovered = dailyRecovered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date + "2020";
    }

    public String getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public String getTotalDeceased() {
        return totalDeceased;
    }

    public void setTotalDeceased(String totalDeceased) {
        this.totalDeceased = totalDeceased;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    @Override
    public int compareTo(NationalTimeData o) {
        String st = getDate()+ "2020";
        return st.compareTo(o.getDate()+"20202");
    }
}
