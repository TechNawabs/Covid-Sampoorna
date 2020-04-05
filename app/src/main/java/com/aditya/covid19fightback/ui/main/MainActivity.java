package com.aditya.covid19fightback.ui.main;

import android.os.Bundle;

import com.aditya.covid19fightback.R;
import com.aditya.covid19fightback.base.BaseActivity;
import com.aditya.covid19fightback.ui.daily.DailyListFragment;
import com.aditya.covid19fightback.ui.national.NationalListFragment;
import com.aditya.covid19fightback.ui.raw.RawListFragment;
import com.aditya.covid19fightback.ui.state.StateListFragment;
import com.aditya.covid19fightback.ui.travel.TravelListFragment;

public class MainActivity extends BaseActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.screenContainer, new DailyListFragment()).commit();
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.screenContainer, new NationalListFragment()).commit();
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.screenContainer, new RawListFragment()).commit();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.screenContainer, new StateListFragment()).commit();
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.screenContainer, new TravelListFragment()).commit();
        }
    }
}
