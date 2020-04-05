package com.aditya.covid19fightback.data.rest.daily;

import com.aditya.covid19fightback.data.model.daily.DailyStates;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface DailyService {

    @GET("states_daily.json")
    Single<List<DailyStates>> loadDailyStat();

}
