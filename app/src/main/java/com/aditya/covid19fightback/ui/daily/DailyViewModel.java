package com.aditya.covid19fightback.ui.daily;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aditya.covid19fightback.data.model.daily.DailyStates;
import com.aditya.covid19fightback.data.rest.daily.DailyRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class DailyViewModel extends ViewModel {

    private final DailyRepository dailyRepository;
    private CompositeDisposable compositeDisposable;

    private final MutableLiveData<List<DailyStates>> dailyResponse = new MutableLiveData<List<DailyStates>>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public DailyViewModel(DailyRepository dailyRepository) {
        this.dailyRepository = dailyRepository;
        compositeDisposable = new CompositeDisposable();
        fetchDailyRepositoryResponse();
    }

    public MutableLiveData<List<DailyStates>> getDailyResponse() {
        return dailyResponse;
    }

    public MutableLiveData<Boolean> getError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchDailyRepositoryResponse() {
        loading.setValue(true);
        compositeDisposable.add(dailyRepository.loadDailyStats()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<List<DailyStates>>() {
            @Override
            public void onSuccess(List<DailyStates> dailyStates) {
                repoLoadError.setValue(false);
                dailyResponse.setValue(dailyStates);
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
