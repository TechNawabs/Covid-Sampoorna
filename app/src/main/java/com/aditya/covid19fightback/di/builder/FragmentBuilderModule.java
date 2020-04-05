package com.aditya.covid19fightback.di.builder;

import com.aditya.covid19fightback.ui.daily.DailyListFragment;
import com.aditya.covid19fightback.ui.national.NationalListFragment;
import com.aditya.covid19fightback.ui.raw.RawListFragment;
import com.aditya.covid19fightback.ui.state.StateListFragment;
import com.aditya.covid19fightback.ui.travel.TravelListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract DailyListFragment provideDailyListFragment();

    @ContributesAndroidInjector
    abstract NationalListFragment provideNationalListFragment();

    @ContributesAndroidInjector
    abstract RawListFragment provideRawListFragment();

    @ContributesAndroidInjector
    abstract StateListFragment provideStateListFragment();

    @ContributesAndroidInjector
    abstract TravelListFragment provideTravelListFragment();

}
