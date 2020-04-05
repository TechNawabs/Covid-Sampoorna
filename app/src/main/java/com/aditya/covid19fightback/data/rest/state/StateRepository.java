package com.aditya.covid19fightback.data.rest.state;

import com.aditya.covid19fightback.data.model.state.State;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class StateRepository {

    private final StateService stateService;

    @Inject
    public StateRepository(StateService stateService) {
        this.stateService = stateService;
    }

    public Single<List<State>> loadStateStats() {
        return stateService.loadStateStat();
    }

}
