package com.technawabs.covid_sampurn.data.rest.helpline;

import com.technawabs.covid_sampurn.data.model.daily.DailyStates;
import com.technawabs.covid_sampurn.data.model.helpline.HelplineData;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface HelplineService {

    @GET("states_daily.json")
    Single<HelplineData> loadHelplineData();

}
