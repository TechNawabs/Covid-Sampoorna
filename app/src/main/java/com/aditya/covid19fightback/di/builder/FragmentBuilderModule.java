package com.aditya.covid19fightback.di.builder;

import com.aditya.covid19fightback.ui.daily.DailyListFragment;
import com.aditya.covid19fightback.ui.national.NationalListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract DailyListFragment provideDailyListFragment();

    @ContributesAndroidInjector
    abstract NationalListFragment provideNationalListFragment();

}
