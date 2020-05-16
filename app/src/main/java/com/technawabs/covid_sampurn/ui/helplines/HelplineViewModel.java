package com.technawabs.covid_sampurn.ui.helplines;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.technawabs.covid_sampurn.data.model.helpline.HelplineData;
import com.technawabs.covid_sampurn.data.rest.helpline.HelplineRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HelplineViewModel extends ViewModel {

    private final HelplineRepository helplineRepository;
    private CompositeDisposable compositeDisposable;

    private final MutableLiveData<HelplineData> helplineResponse = new MutableLiveData<HelplineData>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    private MutableLiveData<String> mText;

    @Inject
    public HelplineViewModel(HelplineRepository helplineRepository) {
        this.helplineRepository = helplineRepository;
        compositeDisposable = new CompositeDisposable();

        mText = new MutableLiveData<>();
        mText.setValue("This is helpline fragment");
    }

    public MutableLiveData<HelplineData> getHelplineResponse() {
        return helplineResponse;
    }

    public MutableLiveData<Boolean> getError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchHelplineResponse() {
        loading.setValue(true);
        compositeDisposable.add(helplineRepository.loadHelplines()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<HelplineData>() {
                    @Override
                    public void onSuccess(HelplineData helplineData) {
                        repoLoadError.setValue(false);
                        helplineResponse.setValue(helplineData);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        repoLoadError.setValue(true);
                        loading.setValue(false);
                    }
                })
        );
    }

    public LiveData<String> getText() {
        return mText;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }

}