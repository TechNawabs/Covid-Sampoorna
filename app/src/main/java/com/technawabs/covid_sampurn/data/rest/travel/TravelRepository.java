package com.technawabs.covid_sampurn.data.rest.travel;

import com.technawabs.covid_sampurn.data.model.travel.TravelStat;

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
