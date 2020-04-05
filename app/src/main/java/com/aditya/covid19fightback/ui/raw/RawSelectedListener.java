package com.aditya.covid19fightback.ui.raw;

import com.aditya.covid19fightback.data.model.daily.DailyStates;
import com.aditya.covid19fightback.data.model.raw.RawData;

public interface RawSelectedListener {

    void onRawStatSelected(RawData dailyStat);

}
