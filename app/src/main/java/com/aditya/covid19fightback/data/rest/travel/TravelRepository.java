package com.aditya.covid19fightback.data.rest.travel;

import com.aditya.covid19fightback.data.model.travel.TravelStat;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class TravelRepository {

    private final TravelService travelService;

    @Inject
    public TravelRepository(TravelService travelService) {
        this.travelService = travelService;
    }

    public Single<TravelStat> loadTravelStats() {
        return travelService.loadTravelStat();
    }


}
