package com.aditya.covid19fightback.di.builder;


import com.aditya.covid19fightback.ui.daily.DailyListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract DailyListFragment provideDailyListFragment();

}
