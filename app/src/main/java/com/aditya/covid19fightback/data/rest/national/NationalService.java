package com.aditya.covid19fightback.data.rest.national;

import com.aditya.covid19fightback.data.model.national.NationalTimeStats;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface NationalService {

    @GET("data.json")
    Single<NationalTimeStats> loadNationalTimeStat();

}
