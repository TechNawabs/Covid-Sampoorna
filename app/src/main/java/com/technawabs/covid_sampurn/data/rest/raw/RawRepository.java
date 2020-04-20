package com.technawabs.covid_sampurn.data.rest.raw;

import com.technawabs.covid_sampurn.data.model.raw.RawStat;

import javax.inject.Inject;

import io.reactivex.Single;

public class RawRepository {

    private final RawService rawService;

    @Inject
    public RawRepository(RawService rawService) {
        this.rawService = rawService;
    }

    public Single<RawStat> loadRawDataStats() {
        return rawService.loadRawDataStat();
    }

}
