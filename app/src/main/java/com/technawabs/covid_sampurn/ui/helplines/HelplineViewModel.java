package com.technawabs.covid_sampurn.ui.helplines;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HelplineViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HelplineViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is helpline fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}