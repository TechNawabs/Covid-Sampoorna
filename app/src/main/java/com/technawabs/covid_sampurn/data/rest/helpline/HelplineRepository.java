package com.technawabs.covid_sampurn.data.rest.helpline;

import com.technawabs.covid_sampurn.data.model.daily.DailyStates;
import com.technawabs.covid_sampurn.data.model.helpline.HelplineData;

import javax.inject.Inject;

import io.reactivex.Single;

public class HelplineRepository {

    private HelplineService helplineService;

    @Inject
    public HelplineRepository(HelplineService helplineService) {
        this.helplineService = helplineService;
    }

    public Single<HelplineData> loadHelplines() {
        return helplineService.loadHelplineData();
    }

}
