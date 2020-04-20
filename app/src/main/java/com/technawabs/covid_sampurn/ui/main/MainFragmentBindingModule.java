package com.technawabs.covid_sampurn.ui.main;

import com.technawabs.covid_sampurn.ui.daily.DailyListFragment;
import com.technawabs.covid_sampurn.ui.national.NationalListFragment;
import com.technawabs.covid_sampurn.ui.raw.RawListFragment;
import com.technawabs.covid_sampurn.ui.state.StateListFragment;
import com.technawabs.covid_sampurn.ui.travel.TravelListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

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