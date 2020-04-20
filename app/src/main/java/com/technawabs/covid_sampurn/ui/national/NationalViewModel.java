package com.technawabs.covid_sampurn.ui.national;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.technawabs.covid_sampurn.data.model.national.NationalTimeStats;
import com.technawabs.covid_sampurn.data.rest.national.NationalRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class NationalViewModel extends ViewModel {

    private final NationalRepository nationalRepository;
    private CompositeDisposable compositeDisposable;

    private final MutableLiveData<NationalTimeStats> nationalTimeResponse = new MutableLiveData<NationalTimeStats>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public NationalViewModel(NationalRepository nationalRepository) {
        this.nationalRepository = nationalRepository;
        compositeDisposable = new CompositeDisposable();
        fetchNationalTimeStat();
    }

    public MutableLiveData<NationalTimeStats> getNationalResponse() {
        return nationalTimeResponse;
    }

    public MutableLiveData<Boolean> getRepoLoadError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchNationalTimeStat() {
        loading.setValue(true);
        compositeDisposable.add(nationalRepository.loadNationalTimeStats()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<NationalTimeStats>() {
                    @Override
                    public void onSuccess(NationalTimeStats nationalTimeStats) {
                        repoLoadError.setValue(false);
                        nationalTimeResponse.setValue(nationalTimeStats);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        repoLoadError.setValue(true);
                        loading.setValue(false);
                    }
                }));
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
