package com.aditya.covid19fightback.data.rest.travel;

import com.aditya.covid19fightback.data.model.travel.Travel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class TravelRepository {

    private final TravelService travelService;

    @Inject
    public TravelRepository(TravelService travelService) {
        this.travelService = travelService;
    }

    public Single<List<Travel>> loadTravelStats() {
        return travelService.loadTravelStat();
    }


}
