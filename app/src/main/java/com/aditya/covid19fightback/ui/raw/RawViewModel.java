package com.aditya.covid19fightback.ui.raw;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aditya.covid19fightback.data.model.raw.RawData;
import com.aditya.covid19fightback.data.rest.raw.RawRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class RawViewModel extends ViewModel {

    private final RawRepository rawRepository;
    private CompositeDisposable compositeDisposable;

    private final MutableLiveData<List<RawData>> rawDataStat = new MutableLiveData<List<RawData>>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public RawViewModel(RawRepository rawRepository) {
        this.rawRepository = rawRepository;
        compositeDisposable = new CompositeDisposable();
        fetchRawData();
    }

    public MutableLiveData<List<RawData>> getRawResponse() {
        return rawDataStat;
    }

    public MutableLiveData<Boolean> getRepoLoadError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchRawData() {
//        loading.setValue(true);
//        compositeDisposable.add();
    }
}
