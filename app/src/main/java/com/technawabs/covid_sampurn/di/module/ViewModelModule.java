package com.technawabs.covid_sampurn.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.technawabs.covid_sampurn.di.util.ViewModelKey;
import com.technawabs.covid_sampurn.ui.advice.AdviceViewModel;
import com.technawabs.covid_sampurn.ui.daily.DailyViewModel;
import com.technawabs.covid_sampurn.ui.dashboard.DashboardViewModel;
import com.technawabs.covid_sampurn.ui.demographic.DemographicViewModel;
import com.technawabs.covid_sampurn.ui.essential.EssentialViewModel;
import com.technawabs.covid_sampurn.ui.helplines.HelplineViewModel;
import com.technawabs.covid_sampurn.ui.national.NationalViewModel;
import com.technawabs.covid_sampurn.ui.national.adapter.GraphViewModel;
import com.technawabs.covid_sampurn.ui.notifications.NotificationsViewModel;
import com.technawabs.covid_sampurn.ui.raw.RawViewModel;
import com.technawabs.covid_sampurn.ui.state.StateViewModel;
import com.technawabs.covid_sampurn.ui.travel.TravelViewModel;
import com.technawabs.covid_sampurn.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AdviceViewModel.class)
    abstract ViewModel bindAdviceResponse(AdviceViewModel adviceViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DailyViewModel.class)
    abstract ViewModel bindDailyRepositoryResponse(DailyViewModel repositoryResponseViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel.class)
    abstract ViewModel bindDashboardResponse(DashboardViewModel dashboardViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DemographicViewModel.class)
    abstract ViewModel bindDemographicResponse(DemographicViewModel demographicViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(EssentialViewModel.class)
    abstract ViewModel bindEssentialResponse(EssentialViewModel essentialViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(GraphViewModel.class)
    abstract ViewModel bindGraphResponse(GraphViewModel graphViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HelplineViewModel.class)
    abstract ViewModel bindHelplineResponse(HelplineViewModel helplineViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NationalViewModel.class)
    abstract ViewModel bindNationalRepositoryResponse(NationalViewModel nationalViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NotificationsViewModel.class)
    abstract ViewModel bindNotificationsResponse(NotificationsViewModel notificationsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RawViewModel.class)
    abstract ViewModel bindRawRepositoryResponse(RawViewModel rawViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(StateViewModel.class)
    abstract ViewModel bindStateRepositoryResponse(StateViewModel rawViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TravelViewModel.class)
    abstract ViewModel bindTravelRepositoryResponse(TravelViewModel travelViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindTravelRepositoryResponseFactory(
            ViewModelFactory viewModelFactory);

}
