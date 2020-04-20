package com.technawabs.covid_sampurn.data.rest.raw;

import com.technawabs.covid_sampurn.data.model.raw.RawStat;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RawService {

    @GET("raw_data.json")
    Single<RawStat> loadRawDataStat();

}
