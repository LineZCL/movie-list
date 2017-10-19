package com.aline.movielist;

import android.app.Activity;
import android.app.Application;

import com.aline.movielist.dagger.component.DaggerMyApplicationComponent;
import com.aline.movielist.dagger.component.MyApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by aline on 19/10/17.
 */

public class MyApplication extends Application implements HasActivityInjector {

    private MyApplicationComponent myApplicationComponent;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplicationComponent = DaggerMyApplicationComponent.builder().build();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    public MyApplicationComponent getMyApplicationComponent() {
        return myApplicationComponent;
    }
}
