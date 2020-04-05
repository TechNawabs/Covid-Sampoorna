package com.aditya.covid19fightback.ui.national;

import com.aditya.covid19fightback.data.model.daily.DailyStates;
import com.aditya.covid19fightback.data.model.national.NationalTimeStats;

public interface NationalSelectedListener {

    void onNationalStatSelected(NationalTimeStats nationalTimeStats);

}
