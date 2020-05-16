package com.technawabs.covid_sampurn.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.technawabs.covid_sampurn.di.util.ViewModelKey;
import com.technawabs.covid_sampurn.ui.advice.AdviceViewModel;
import com.technawabs.covid_sampurn.ui.daily.DailyViewModel;
import com.technawabs.covid_sampurn.ui.dashboard.DashboardViewModel;
import com.technawabs.covid_sampurn.ui.helplines.HelplineViewModel;
import com.technawabs.covid_sampurn.ui.national.NationalViewModel;
import com.technawabs.covid_sampurn.ui.raw.RawViewModel;
import com.technawabs.covid_sampurn.ui.state.StateViewModel;
import com.technawabs.covid_sampurn.ui.travel.TravelViewModel;
import com.technawabs.covid_sampurn.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(AdviceViewModel.class)
//    abstract ViewModel bindAdviceResponse(AdviceViewModel adviceViewModel);
//
//    @Binds
//    abstract ViewModelProvider.Factory bindAdviceResponseFactory(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(DailyViewModel.class)
    abstract ViewModel bindDailyRepositoryResponse(DailyViewModel repositoryResponseViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindTrendingRepositoryResponseFactory(ViewModelFactory viewModelFactory);

//    @Binds
//    @IntoMap
//    @ViewModelKey(DashboardViewModel.class)
//    abstract ViewModel bindDashboardResponse(DashboardViewModel dashboardViewModel);
//
//    @Binds
//    abstract ViewModelProvider.Factory bindDashboardResponseFactory(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(HelplineViewModel.class)
    abstract ViewModel bindHelplineResponse(HelplineViewModel helplineViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindHelplineResponseFactory(ViewModelFactory viewModelFactory);

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

    @Binds
    @IntoMap
    @ViewModelKey(TravelViewModel.class)
    abstract ViewModel bindTravelRepositoryResponse(TravelViewModel travelViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindTravelRepositoryResponseFactory(
            ViewModelFactory viewModelFactory);

}
