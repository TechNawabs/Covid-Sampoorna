package com.technawabs.covid_sampurn.ui.demographic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DemographicViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DemographicViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is demographic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}