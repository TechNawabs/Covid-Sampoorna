package com.aditya.covid19fightback.data.rest.national;

import com.aditya.covid19fightback.data.model.national.NationalTimeStats;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class NationalRepository {

    private final NationalService nationalService;

    @Inject
    public  NationalRepository(NationalService nationalService) {
        this.nationalService = nationalService;
    }

    public Single<List<NationalTimeStats>> loadNationalTimeStats() {
        return nationalService.loadNationalTimeStat();
    }

}
