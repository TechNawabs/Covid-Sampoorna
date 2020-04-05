package com.aditya.covid19fightback.ui.main;

import com.aditya.covid19fightback.ui.daily.DailyListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract DailyListFragment provideDailyListFragment();

}