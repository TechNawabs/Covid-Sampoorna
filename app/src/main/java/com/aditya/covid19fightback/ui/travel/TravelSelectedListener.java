package com.aditya.covid19fightback.ui.travel;

import com.aditya.covid19fightback.data.model.travel.TravelData;
import com.aditya.covid19fightback.data.model.travel.TravelStat;

public interface TravelSelectedListener {

    void onTravelStatSelected(TravelData travelData);

}
