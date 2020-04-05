package com.aditya.covid19fightback.ui.travel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aditya.covid19fightback.data.model.travel.TravelStat;
import com.aditya.covid19fightback.data.rest.travel.TravelRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class TravelViewModel extends ViewModel {

    private final TravelRepository travelRepository;
    private CompositeDisposable compositeDisposable;

    private final MutableLiveData<TravelStat> travelResponse = new MutableLiveData<TravelStat>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public TravelViewModel(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
        compositeDisposable = new CompositeDisposable();
        fetchTravelStat();
    }

    public MutableLiveData<TravelStat> getTravelStatResponse() {
        return travelResponse;
    }

    public MutableLiveData<Boolean> getRepoLoadError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchTravelStat() {
        loading.setValue(true);
        compositeDisposable.add(travelRepository.loadTravelStats()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<TravelStat>() {
                    @Override
                    public void onSuccess(TravelStat travelStat) {
                        repoLoadError.setValue(false);
                        travelResponse.setValue(travelStat);
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
