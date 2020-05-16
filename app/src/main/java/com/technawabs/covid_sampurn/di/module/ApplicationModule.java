package com.technawabs.covid_sampurn.di.module;

import com.technawabs.covid_sampurn.data.rest.daily.DailyService;
import com.technawabs.covid_sampurn.data.rest.helpline.HelplineService;
import com.technawabs.covid_sampurn.data.rest.national.NationalService;
import com.technawabs.covid_sampurn.data.rest.raw.RawService;
import com.technawabs.covid_sampurn.data.rest.state.StateService;
import com.technawabs.covid_sampurn.data.rest.travel.TravelService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class ApplicationModule {

    private static final String BASE_URL = "https://api.covid19india.org/";

    @Singleton
    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static DailyService provideDailyService(Retrofit retrofit) {
        return retrofit.create(DailyService.class);
    }

    @Singleton
    @Provides
    static HelplineService provideHelplineService(Retrofit retrofit) {
        return retrofit.create(HelplineService.class);
    }

    @Singleton
    @Provides
    static NationalService provideNationalService(Retrofit retrofit) {
        return retrofit.create(NationalService.class);
    }

    @Singleton
    @Provides
    static RawService provideRawService(Retrofit retrofit) {
        return retrofit.create(RawService.class);
    }

    @Singleton
    @Provides
    static StateService provideStateService(Retrofit retrofit) {
        return retrofit.create(StateService.class);
    }

    @Singleton
    @Provides
    static TravelService provideTravelService(Retrofit retrofit) {
        return retrofit.create(TravelService.class);
    }

}