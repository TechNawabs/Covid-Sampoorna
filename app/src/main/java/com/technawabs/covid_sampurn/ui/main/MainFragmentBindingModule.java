package com.technawabs.covid_sampurn.ui.main;

import com.technawabs.covid_sampurn.ui.advice.AdviceFragment;
import com.technawabs.covid_sampurn.ui.daily.DailyListFragment;
import com.technawabs.covid_sampurn.ui.dashboard.DashboardFragment;
import com.technawabs.covid_sampurn.ui.demographic.DemographicFragment;
import com.technawabs.covid_sampurn.ui.essential.EssentialFragment;
import com.technawabs.covid_sampurn.ui.helplines.HelplineFragment;
import com.technawabs.covid_sampurn.ui.national.NationalListFragment;
import com.technawabs.covid_sampurn.ui.national.adapter.GraphFragment;
import com.technawabs.covid_sampurn.ui.notifications.NotificationsFragment;
import com.technawabs.covid_sampurn.ui.raw.RawListFragment;
import com.technawabs.covid_sampurn.ui.state.StateListFragment;
import com.technawabs.covid_sampurn.ui.travel.TravelListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract AdviceFragment provideAdviceFragment();

    @ContributesAndroidInjector
    abstract DashboardFragment provideDashboardFragment();

    @ContributesAndroidInjector
    abstract DailyListFragment provideDailyListFragment();

    @ContributesAndroidInjector
    abstract DemographicFragment provideDemographicFragment();

    @ContributesAndroidInjector
    abstract EssentialFragment provideEssentialFragment();

    @ContributesAndroidInjector
    abstract HelplineFragment provideHelplineFragment();

    @ContributesAndroidInjector
    abstract GraphFragment provideGraphFragment();

    @ContributesAndroidInjector
    abstract NationalListFragment provideNationalListFragment();

    @ContributesAndroidInjector
    abstract NotificationsFragment provideNotificationsFragment();

    @ContributesAndroidInjector
    abstract RawListFragment provideRawListFragment();

    @ContributesAndroidInjector
    abstract StateListFragment provideStateListFragment();

    @ContributesAndroidInjector
    abstract TravelListFragment provideTravelListFragment();

}