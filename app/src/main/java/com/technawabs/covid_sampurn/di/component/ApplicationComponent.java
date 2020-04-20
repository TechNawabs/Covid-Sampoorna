package com.technawabs.covid_sampurn.di.component;

import android.app.Application;

import com.technawabs.covid_sampurn.base.BaseApplication;
import com.technawabs.covid_sampurn.di.module.ActivityBindingModule;
import com.technawabs.covid_sampurn.di.module.ApplicationModule;
import com.technawabs.covid_sampurn.di.module.ContextModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ContextModule.class,
        ApplicationModule.class,
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class
})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }

}