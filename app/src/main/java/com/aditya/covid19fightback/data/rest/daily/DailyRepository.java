package com.aditya.covid19fightback.data.rest.daily;

import com.aditya.covid19fightback.data.model.daily.DailyStates;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class DailyRepository {

    private DailyService dailyService;

    @Inject
    public DailyRepository(DailyService dailyService) {
        this.dailyService = dailyService;
    }

    public Single<List<DailyStates>> loadDailyStats() {
        return dailyService.loadDailyStat();
    }

}
