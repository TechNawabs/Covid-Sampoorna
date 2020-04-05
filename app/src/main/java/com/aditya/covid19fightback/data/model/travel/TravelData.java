package com.aditya.covid19fightback.data.model.travel;

import com.google.gson.annotations.SerializedName;

public class TravelData {

    @SerializedName("_cn6ca")
    private String code;
    @SerializedName("accuracylocation")
    private String accuracyLocation;
    @SerializedName("address")
    private String address;
    @SerializedName("datasource")
    private String dataSource;
    @SerializedName("latlong")
    private String latlong;
    @SerializedName("modeoftravel")
    private String modeOfTravel;
    @SerializedName("pi")
    private String pid;
    @SerializedName("placename")
    private String placeName;
    @SerializedName("timefrom")
    private String timeFrom;
    @SerializedName("timeto")
    private String timeTo;
    @SerializedName("type")
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccuracyLocation() {
        return accuracyLocation;
    }

    public void setAccuracyLocation(String accuracyLocation) {
        this.accuracyLocation = accuracyLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getLatlong() {
        return latlong;
    }

    public void setLatlong(String latlong) {
        this.latlong = latlong;
    }

    public String getModeOfTravel() {
        return modeOfTravel;
    }

    public void setModeOfTravel(String modeOfTravel) {
        this.modeOfTravel = modeOfTravel;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
