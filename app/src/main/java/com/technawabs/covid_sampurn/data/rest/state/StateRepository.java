package com.technawabs.covid_sampurn.data.rest.state;

import com.technawabs.covid_sampurn.data.model.state.StateData;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class StateRepository {

    private final StateService stateService;

    @Inject
    public StateRepository(StateService stateService) {
        this.stateService = stateService;
    }

    public Single<List<StateData>> loadStateStats() {
        return stateService.loadStateStat();
    }

}
