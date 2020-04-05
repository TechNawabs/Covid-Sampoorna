package com.aditya.covid19fightback.data.rest.state;

import com.aditya.covid19fightback.data.model.state.StateStat;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface StateService {

    @GET("states_daily.json")
    Single<StateStat> loadStateStat();

}
