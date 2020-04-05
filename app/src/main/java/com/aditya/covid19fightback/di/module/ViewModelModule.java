package com.aditya.covid19fightback.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.aditya.covid19fightback.di.util.ViewModelKey;
import com.aditya.covid19fightback.ui.daily.DailyViewModel;
import com.aditya.covid19fightback.ui.national.NationalViewModel;
import com.aditya.covid19fightback.ui.raw.RawViewModel;
import com.aditya.covid19fightback.ui.state.StateViewModel;
import com.aditya.covid19fightback.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DailyViewModel.class)
    abstract ViewModel bindDailyRepositoryResponse(DailyViewModel repositoryResponseViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindTrendingRepositoryResponseFactory(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(NationalViewModel.class)
    abstract ViewModel bindNationalRepositoryResponse(NationalViewModel nationalViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindNationalRepositoryResponseFactory(
            ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(RawViewModel.class)
    abstract ViewModel bindRawRepositoryResponse(RawViewModel rawViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindRawRepositoryResponseFactory(
            ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(StateViewModel.class)
    abstract ViewModel bindStateRepositoryResponse(StateViewModel rawViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindStateRepositoryResponseFactory(
            ViewModelFactory viewModelFactory);

}
