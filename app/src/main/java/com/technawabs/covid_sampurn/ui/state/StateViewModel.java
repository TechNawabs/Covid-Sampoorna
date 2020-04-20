package com.technawabs.covid_sampurn.ui.state;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.technawabs.covid_sampurn.data.model.state.StateData;
import com.technawabs.covid_sampurn.data.rest.state.StateRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class StateViewModel extends ViewModel {

    private final StateRepository stateRepository;
    private CompositeDisposable compositeDisposable;

    private final MutableLiveData<List<StateData>> stateResponse = new MutableLiveData<List<StateData>>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public StateViewModel(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
        compositeDisposable = new CompositeDisposable();
        fetchStateStat();
    }

    public MutableLiveData<List<StateData>> getStateResponse() {
        return stateResponse;
    }

    public MutableLiveData<Boolean> getRepoLoadError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchStateStat() {
        loading.setValue(true);
        compositeDisposable.add(stateRepository.loadStateStats()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<StateData>>() {
                    @Override
                    public void onSuccess(List<StateData> rawStat) {
                        repoLoadError.setValue(false);
                        stateResponse.setValue(rawStat);
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
