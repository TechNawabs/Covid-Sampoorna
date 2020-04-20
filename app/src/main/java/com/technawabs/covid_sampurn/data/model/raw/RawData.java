package com.technawabs.covid_sampurn.data.model.raw;

import com.google.gson.annotations.SerializedName;

public class RawData {

    @SerializedName("agebracket")
    private String ageBracket;
    @SerializedName("backupnotes")
    private String backupNotes;
    @SerializedName("contractedfromwhichpatientsuspected")
    private String contractedFromWhichPatientSuspected;
    @SerializedName("currentstatus")
    private String currentStatus;
    @SerializedName("dateannounced")
    private String dateAnnounced;
    @SerializedName("detectedcity")
    private String detectedCity;
    @SerializedName("detecteddistrict")
    private String detectedDistrict;
    @SerializedName("detectedstate")
    private String detectedState;
    @SerializedName("estimatedonsetdate")
    private String estimatedOnSetDate;
    @SerializedName("gender")
    private String gender;
    @SerializedName("nationality")
    private String nationality;
    @SerializedName("notes")
    private String notes;
    @SerializedName("patientnumber")
    private String patientNumber;
    @SerializedName("source1")
    private String source1;
    @SerializedName("source2")
    private String source2;
    @SerializedName("source3")
    private String source3;
    @SerializedName("statecode")
    private String stateCode;
    @SerializedName("statepatientnumber")
    private String statePatientNumber;
    @SerializedName("statuschangedate")
    private String statusChangeDate;
    @SerializedName("typeoftransmission")
    private String typeOfTransmission;

    public String getAgeBracket() {
        return ageBracket;
    }

    public void setAgeBracket(String ageBracket) {
        this.ageBracket = ageBracket;
    }

    public String getBackupNotes() {
        return backupNotes;
    }

    public void setBackupNotes(String backupNotes) {
        this.backupNotes = backupNotes;
    }

    public String getContractedFromWhichPatientSuspected() {
        return contractedFromWhichPatientSuspected;
    }

    public void setContractedFromWhichPatientSuspected(String contractedFromWhichPatientSuspected) {
        this.contractedFromWhichPatientSuspected = contractedFromWhichPatientSuspected;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getDateAnnounced() {
        return dateAnnounced;
    }

    public void setDateAnnounced(String dateAnnounced) {
        this.dateAnnounced = dateAnnounced;
    }

    public String getDetectedCity() {
        return detectedCity;
    }

    public void setDetectedCity(String detectedCity) {
        this.detectedCity = detectedCity;
    }

    public String getDetectedDistrict() {
        return detectedDistrict;
    }

    public void setDetectedDistrict(String detectedDistrict) {
        this.detectedDistrict = detectedDistrict;
    }

    public String getDetectedState() {
        return detectedState;
    }

    public void setDetectedState(String detectedState) {
        this.detectedState = detectedState;
    }

    public String getEstimatedOnSetDate() {
        return estimatedOnSetDate;
    }

    public void setEstimatedOnSetDate(String estimatedOnSetDate) {
        this.estimatedOnSetDate = estimatedOnSetDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getSource1() {
        return source1;
    }

    public void setSource1(String source1) {
        this.source1 = source1;
    }

    public String getSource2() {
        return source2;
    }

    public void setSource2(String source2) {
        this.source2 = source2;
    }

    public String getSource3() {
        return source3;
    }

    public void setSource3(String source3) {
        this.source3 = source3;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStatePatientNumber() {
        return statePatientNumber;
    }

    public void setStatePatientNumber(String statePatientNumber) {
        this.statePatientNumber = statePatientNumber;
    }

    public String getStatusChangeDate() {
        return statusChangeDate;
    }

    public void setStatusChangeDate(String statusChangeDate) {
        this.statusChangeDate = statusChangeDate;
    }

    public String getTypeOfTransmission() {
        return typeOfTransmission;
    }

    public void setTypeOfTransmission(String typeOfTransmission) {
        this.typeOfTransmission = typeOfTransmission;
    }

}
