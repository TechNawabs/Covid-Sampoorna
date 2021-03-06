package com.technawabs.covid_sampurn.di.module;


import com.technawabs.covid_sampurn.ui.main.MainActivity;
import com.technawabs.covid_sampurn.ui.main.MainFragmentBindingModule;
import com.technawabs.covid_sampurn.ui.splash.SplashScreen;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = { MainFragmentBindingModule.class })
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = { MainFragmentBindingModule.class })
    abstract SplashScreen bindSplashScreen();

}