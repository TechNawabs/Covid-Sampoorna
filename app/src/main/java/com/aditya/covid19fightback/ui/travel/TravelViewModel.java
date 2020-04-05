package com.aditya.covid19fightback.ui.travel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aditya.covid19fightback.data.model.travel.Travel;
import com.aditya.covid19fightback.data.rest.travel.TravelRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class TravelViewModel extends ViewModel {

    private final TravelRepository travelRepository;
    private CompositeDisposable compositeDisposable;

    private final MutableLiveData<List<Travel>> travelStat = new MutableLiveData<List<Travel>>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public TravelViewModel(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
        compositeDisposable = new CompositeDisposable();
        fetchTravelStat();
    }

    public MutableLiveData<List<Travel>> getTravelStatResponse() {
        return travelStat;
    }

    public MutableLiveData<Boolean> getRepoLoadError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchTravelStat() {
//        loading.setValue(true);
//        compositeDisposable.add();
    }

}
