package com.aditya.covid19fightback.data.rest.raw;

import com.aditya.covid19fightback.data.model.raw.RawStat;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RawService {

    @GET("raw_data.json")
    Single<RawStat> loadRawDataStat();

}
