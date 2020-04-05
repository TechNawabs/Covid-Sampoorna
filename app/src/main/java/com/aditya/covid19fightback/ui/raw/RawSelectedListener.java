package com.aditya.covid19fightback.ui.raw;

import com.aditya.covid19fightback.data.model.raw.RawData;
import com.aditya.covid19fightback.data.model.raw.RawStat;

public interface RawSelectedListener {

    void onRawStatSelected(RawData rawData);

}
