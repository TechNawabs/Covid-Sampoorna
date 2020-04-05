package com.aditya.covid19fightback.ui.national;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aditya.covid19fightback.data.model.national.NationalTimeStats;
import com.aditya.covid19fightback.data.rest.national.NationalRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class NationalViewModel extends ViewModel {

    private final NationalRepository nationalRepository;
    private CompositeDisposable compositeDisposable;

    private final MutableLiveData<List<NationalTimeStats>> nationalTimeStats = new MutableLiveData<List<NationalTimeStats>>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public NationalViewModel(NationalRepository nationalRepository) {
        this.nationalRepository = nationalRepository;
        compositeDisposable = new CompositeDisposable();
        fetchNationalTimeStat();
    }

    public MutableLiveData<List<NationalTimeStats>> getNationalResponse() {
        return nationalTimeStats;
    }

    public MutableLiveData<Boolean> getRepoLoadError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchNationalTimeStat() {
//        loading.setValue(true);
//        compositeDisposable.add();
    }
}
