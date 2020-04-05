package com.aditya.covid19fightback.di.module;

import com.aditya.covid19fightback.data.rest.daily.DailyService;
import com.aditya.covid19fightback.data.rest.national.NationalService;
import com.aditya.covid19fightback.data.rest.raw.RawService;
import com.aditya.covid19fightback.data.rest.state.StateService;
import com.aditya.covid19fightback.data.rest.travel.TravelService;

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