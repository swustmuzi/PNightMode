package com.muzi.nightmode;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;

import com.muzi.nightmode.util.AppContextUtils;

/**
 * Created by linpu on 17-12-21.
 */

public class ThemeNightModeApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        AppContextUtils.setAppContext(base);
        AppContextUtils.setApplication(this);
    }
}
