package com.technawabs.covid_sampurn.ui.demographic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class DemographicViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    @Inject
    public DemographicViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is demographic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}