package com.muzi.nightmode.util;


import android.app.Application;
import android.content.Context;

public class AppContextUtils {

    private static Context mAppContext;
    private static Application sApplication;

    public static void setAppContext(Context appContext) {
        mAppContext = appContext;
    }

    public static Context getAppContext() {
        return mAppContext;
    }

    public static void setApplication(Application application) {
        sApplication = application;
    }

    public static Application getApplication() {
        return sApplication;
    }

}
