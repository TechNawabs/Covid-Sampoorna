package com.technawabs.covid_sampurn.data.rest.daily;

import com.technawabs.covid_sampurn.data.model.daily.DailyStates;

import javax.inject.Inject;

import io.reactivex.Single;

public class DailyRepository {

    private DailyService dailyService;

    @Inject
    public DailyRepository(DailyService dailyService) {
        this.dailyService = dailyService;
    }

    public Single<DailyStates> loadDailyStats() {
        return dailyService.loadDailyStat();
    }

}
