package com.mbs.mulyono.dmsapp.base;

import android.app.Application;

import com.mbs.mulyono.dmsapp.observer.AppObserver;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class BaseApplication extends Application {
    public AppObserver mAppObserver;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppObserver = new AppObserver();
    }

    public AppObserver getAppObserver(){
        return mAppObserver;
    }
}
