package com.technawabs.covid_sampurn.data.rest.daily;

import com.technawabs.covid_sampurn.data.model.daily.DailyStates;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface DailyService {

    @GET("states_daily.json")
    Single<DailyStates> loadDailyStat();

}
