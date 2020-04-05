package com.aditya.covid19fightback.data.rest.travel;

import com.aditya.covid19fightback.data.model.travel.TravelStat;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface TravelService {

    @GET("travel_history.json")
    Single<TravelStat> loadTravelStat();

}
