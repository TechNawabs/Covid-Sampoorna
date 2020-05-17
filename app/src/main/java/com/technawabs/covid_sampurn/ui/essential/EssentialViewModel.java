package com.technawabs.covid_sampurn.ui.essential;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class EssentialViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    @Inject
    public EssentialViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is essential fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}