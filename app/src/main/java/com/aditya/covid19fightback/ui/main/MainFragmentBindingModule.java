package com.aditya.covid19fightback.ui.main;

import com.aditya.covid19fightback.ui.daily.DailyListFragment;
import com.aditya.covid19fightback.ui.national.NationalListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract DailyListFragment provideDailyListFragment();

    @ContributesAndroidInjector
    abstract NationalListFragment provideNationalListFragment();

}