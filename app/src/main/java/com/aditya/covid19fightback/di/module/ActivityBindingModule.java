package com.aditya.covid19fightback.di.module;


import com.aditya.covid19fightback.ui.main.MainActivity;
import com.aditya.covid19fightback.ui.main.MainFragmentBindingModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = { MainFragmentBindingModule.class })
    abstract MainActivity bindMainActivity();

}