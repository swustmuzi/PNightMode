package com.muzi.support.nightmode;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatDelegate;

public class SharedPrefUtil {

    private static final String PREF_NAME = "pref_night_mode_common";

    private static final String KEY_PREF_NIGHT_MODE = "key_night_mode";

    private SharedPreferences mPreferences;

    private static class Holder {
        private static final SharedPrefUtil sInstance = new SharedPrefUtil();
    }

    public static SharedPrefUtil getInstance() {
        return Holder.sInstance;
    }

    private SharedPrefUtil() {
        mPreferences = AppContextUtils.getAppContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setNightMode(@AppCompatDelegate.NightMode int mode) {
        mPreferences.edit().putInt(KEY_PREF_NIGHT_MODE, mode).apply();
    }

    public @AppCompatDelegate.NightMode int getNightMode() {
        return mPreferences.getInt(KEY_PREF_NIGHT_MODE, AppCompatDelegate.MODE_NIGHT_NO);
    }

}
