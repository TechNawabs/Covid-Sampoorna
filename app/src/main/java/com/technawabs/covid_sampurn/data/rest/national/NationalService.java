package com.technawabs.covid_sampurn.data.rest.national;

import com.technawabs.covid_sampurn.data.model.national.NationalTimeStats;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface NationalService {

    @GET("data.json")
    Single<NationalTimeStats> loadNationalTimeStat();

}
