package com.technawabs.covid_sampurn.ui.raw;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.technawabs.covid_sampurn.data.model.raw.RawStat;
import com.technawabs.covid_sampurn.data.rest.raw.RawRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class RawViewModel extends ViewModel {

    private final RawRepository rawRepository;
    private CompositeDisposable compositeDisposable;

    private final MutableLiveData<RawStat> rawDataStat = new MutableLiveData<RawStat>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public RawViewModel(RawRepository rawRepository) {
        this.rawRepository = rawRepository;
        compositeDisposable = new CompositeDisposable();
        fetchRawData();
    }

    public MutableLiveData<RawStat> getRawResponse() {
        return rawDataStat;
    }

    public MutableLiveData<Boolean> getRepoLoadError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchRawData() {
        loading.setValue(true);
        compositeDisposable.add(rawRepository.loadRawDataStats()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<RawStat>() {
            @Override
            public void onSuccess(RawStat rawStat) {
                repoLoadError.setValue(false);
                rawDataStat.setValue(rawStat);
                loading.setValue(false);
            }

            @Override
            public void onError(Throwable e) {
                repoLoadError.setValue(true);
                loading.setValue(false);
            }
        }));
    }
}
