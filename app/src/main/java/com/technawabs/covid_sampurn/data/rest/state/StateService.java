package com.technawabs.covid_sampurn.data.rest.state;

import com.technawabs.covid_sampurn.data.model.state.StateData;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface StateService {

    @GET("v2/state_district_wise.json")
    Single<List<StateData>> loadStateStat();

}
