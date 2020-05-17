package com.technawabs.covid_sampurn.ui.advice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class AdviceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    @Inject
    public AdviceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is advice fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}