package com.muzi.support.nightmode;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by linpu on 17-12-21.
 */

public class NightModeApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    public void init(){
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
