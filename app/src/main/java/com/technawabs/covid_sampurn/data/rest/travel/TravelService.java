package com.technawabs.covid_sampurn.data.rest.travel;

import com.technawabs.covid_sampurn.data.model.travel.TravelStat;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface TravelService {

    @GET("travel_history.json")
    Single<TravelStat> loadTravelStat();

}
