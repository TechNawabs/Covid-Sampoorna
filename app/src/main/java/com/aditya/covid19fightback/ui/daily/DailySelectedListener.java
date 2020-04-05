package com.aditya.covid19fightback.ui.daily;

import com.aditya.covid19fightback.data.model.daily.DailyData;
import com.aditya.covid19fightback.data.model.daily.DailyStates;

public interface DailySelectedListener {

    void onDailyStatSelected(DailyData dailyData);

}
