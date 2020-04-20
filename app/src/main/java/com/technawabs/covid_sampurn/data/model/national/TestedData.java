package com.technawabs.covid_sampurn.data.model.national;

import com.google.gson.annotations.SerializedName;

public class TestedData {

    @SerializedName("_cyevm")
    public String code;
    @SerializedName("positivecasesfromsamplesreported")
    public String positiveCasesFromSamplesReported;
    @SerializedName("samplereportedtoday")
    public String sampleReportedToday;
    @SerializedName("source")
    public String source;
    @SerializedName("testsconductedbyprivatelabs")
    public String testsConductedbyPrivateLabs;
    @SerializedName("totalindividualstested")
    public String totalIndividualsTested;
    @SerializedName("totalpositivecases")
    public String totalPositiveCases;
    @SerializedName("totalsamplestested")
    public String totalSamplesTested;
    @SerializedName("updatetimestamp")
    public String updateTimestamp;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPositiveCasesFromSamplesReported() {
        return positiveCasesFromSamplesReported;
    }

    public void setPositiveCasesFromSamplesReported(String positiveCasesFromSamplesReported) {
        this.positiveCasesFromSamplesReported = positiveCasesFromSamplesReported;
    }

    public String getSampleReportedToday() {
        return sampleReportedToday;
    }

    public void setSampleReportedToday(String sampleReportedToday) {
        this.sampleReportedToday = sampleReportedToday;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTestsConductedbyPrivateLabs() {
        return testsConductedbyPrivateLabs;
    }

    public void setTestsConductedbyPrivateLabs(String testsConductedbyPrivateLabs) {
        this.testsConductedbyPrivateLabs = testsConductedbyPrivateLabs;
    }

    public String getTotalIndividualsTested() {
        return totalIndividualsTested;
    }

    public void setTotalIndividualsTested(String totalIndividualsTested) {
        this.totalIndividualsTested = totalIndividualsTested;
    }

    public String getTotalPositiveCases() {
        return totalPositiveCases;
    }

    public void setTotalPositiveCases(String totalPositiveCases) {
        this.totalPositiveCases = totalPositiveCases;
    }

    public String getTotalSamplesTested() {
        return totalSamplesTested;
    }

    public void setTotalSamplesTested(String totalSamplesTested) {
        this.totalSamplesTested = totalSamplesTested;
    }

    public String getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(String updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}
