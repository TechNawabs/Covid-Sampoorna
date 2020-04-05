package com.aditya.covid19fightback.ui.state;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aditya.covid19fightback.data.model.state.StateStat;
import com.aditya.covid19fightback.data.rest.state.StateRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class StateViewModel extends ViewModel {

    private final StateRepository stateRepository;
    private CompositeDisposable compositeDisposable;


    private final MutableLiveData<List<StateStat>> rawResponse = new MutableLiveData<List<StateStat>>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public StateViewModel(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
        compositeDisposable = new CompositeDisposable();
        fetchStateStat();
    }

    public MutableLiveData<List<StateStat>> getStateResponse() {
        return rawResponse;
    }

    public MutableLiveData<Boolean> getRepoLoadError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchStateStat() {
//        loading.setValue(true);
//        compositeDisposable.add();
    }
}
