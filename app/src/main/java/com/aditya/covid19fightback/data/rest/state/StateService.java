package com.aditya.covid19fightback.data.rest.state;

import com.aditya.covid19fightback.data.model.state.StateData;
import com.aditya.covid19fightback.data.model.state.StateStat;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface StateService {

    @GET("v2/state_district_wise.json")
    Single<List<StateData>> loadStateStat();

}
