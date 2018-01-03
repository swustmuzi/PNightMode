package com.muzi.support.nightmode;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by linpu on 17-12-21.
 */

public class NightModeApplication extends Application{

    //static {
    //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_ NIGHT_YES);
    //}

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        AppContextUtils.setAppContext(base);
        AppContextUtils.setApplication(this);
    }

    public void init(){

        int nightMode = SharedPrefUtil.getInstance().getNightMode();
        AppCompatDelegate.setDefaultNightMode(nightMode);

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                NightModeActivityManager.getInstance().addAppCompatActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                NightModeActivityManager.getInstance().removeAppCompatActivity(activity);
            }
        });
    }
}
