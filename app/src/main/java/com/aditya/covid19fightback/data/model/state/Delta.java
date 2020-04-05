package com.aditya.covid19fightback.data.model.state;

import com.google.gson.annotations.SerializedName;

public class Delta {

    @SerializedName("confirmed")
    private long confirmed;

    public long getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(long confirmed) {
        this.confirmed = confirmed;
    }
}
