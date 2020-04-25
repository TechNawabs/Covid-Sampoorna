package com.technawabs.covid_sampurn.data.model.national;

import com.google.gson.annotations.SerializedName;

public class TestedData {

    @SerializedName("individualstestedperconfirmedcase")
    public String individualsTestedPerConfirmedCase;
    @SerializedName("positivecasesfromsamplesreported")
    public String positiveCasesFromSamplesReported;
    @SerializedName("samplereportedtoday")
    public String sampleReportedToday;
    @SerializedName("source")
    public String source;
    @SerializedName("testpositivityrate")
    public String testPositivityRate;
    @SerializedName("testsconductedbyprivatelabs")
    public String testsConductedByPrivateLabs;
    @SerializedName("testsperconfirmedcase")
    public String testsPerConfirmedCase;
    @SerializedName("totalindividualstested")
    public String totalIndividualsTested;
    @SerializedName("totalpositivecases")
    public String totalPositiveCases;
    @SerializedName("totalsamplestested")
    public String totalSamplesTested;
    @SerializedName("updatetimestamp")
    public String updateTimestamp;

    public String getIndividualsTestedPerConfirmedCase() {
        return individualsTestedPerConfirmedCase;
    }

    public void setIndividualsTestedPerConfirmedCase(String individualsTestedPerConfirmedCase) {
        this.individualsTestedPerConfirmedCase = individualsTestedPerConfirmedCase;
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

    public String getTestPositivityRate() {
        return testPositivityRate;
    }

    public void setTestPositivityRate(String testPositivityRate) {
        this.testPositivityRate = testPositivityRate;
    }

    public String getTestsConductedByPrivateLabs() {
        return testsConductedByPrivateLabs;
    }

    public void setTestsConductedByPrivateLabs(String testsConductedByPrivateLabs) {
        this.testsConductedByPrivateLabs = testsConductedByPrivateLabs;
    }

    public String getTestsPerConfirmedCase() {
        return testsPerConfirmedCase;
    }

    public void setTestsPerConfirmedCase(String testsPerConfirmedCase) {
        this.testsPerConfirmedCase = testsPerConfirmedCase;
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
