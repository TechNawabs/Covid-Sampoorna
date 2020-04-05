package com.aditya.covid19fightback.data.rest.state;

import com.aditya.covid19fightback.data.model.state.State;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.internal.operators.single.SingleLift;
import retrofit2.http.GET;

public interface StateService {

    @GET("states_daily.json")
    Single<List<State>> loadStateStat();

}
