package com.technawabs.covid_sampurn.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class NotificationsViewModel extends ViewModel {

    private CompositeDisposable compositeDisposable;

    private final MutableLiveData<Boolean> notificationLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    private MutableLiveData<String> mText;
    private final MutableLiveData<String> playStoreURL = new MutableLiveData<>
            ("https://play.google.com/store/apps/details?id=nic.goi.aarogyasetu");
    private final MutableLiveData<String> webPageURL = new MutableLiveData<>
            ("https://www.mygov.in/aarogya-setu-app/");
    private final MutableLiveData<String> facebookPageURL = new MutableLiveData<>
            ("https://www.facebook.com/MyGovIndia/");
    private final MutableLiveData<String> twitterPageURL = new MutableLiveData<>
            ("https://twitter.com/mygovindia");

    @Inject
    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
        fetchRawData();
    }

    public void fetchRawData() {

    }

    public MutableLiveData<Boolean> getRepoLoadError() {
        return notificationLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public LiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<String> getPlayStoreURL() {
        return playStoreURL;
    }

    public MutableLiveData<String> getWebPageURL() {
        return webPageURL;
    }

    public MutableLiveData<String> getFacebookPageURL() {
        return facebookPageURL;
    }

    public MutableLiveData<String> getTwitterPageURL() {
        return twitterPageURL;
    }

}