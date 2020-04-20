package com.technawabs.covid_sampurn.data.model.national;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class StatewiseData {

    public String active;
    public String confirmed;
    public String deaths;
    @SerializedName("deltaconfirmed")
    public String deltaConfirmed;
    @SerializedName("deltadeaths")
    public String deltaDeaths;
    @SerializedName("deltarecovered")
    public String deltaRecovered;
    @SerializedName("lastupdatedtime")
    public Date lastUpdatedTime;
    public String recovered;
    public String state;
    @SerializedName("statecode")
    public String stateCode;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getDeltaConfirmed() {
        return deltaConfirmed;
    }

    public void setDeltaConfirmed(String deltaConfirmed) {
        this.deltaConfirmed = deltaConfirmed;
    }

    public String getDeltaDeaths() {
        return deltaDeaths;
    }

    public void setDeltaDeaths(String deltaDeaths) {
        this.deltaDeaths = deltaDeaths;
    }

    public String getDeltaRecovered() {
        return deltaRecovered;
    }

    public void setDeltaRecovered(String deltaRecovered) {
        this.deltaRecovered = deltaRecovered;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
