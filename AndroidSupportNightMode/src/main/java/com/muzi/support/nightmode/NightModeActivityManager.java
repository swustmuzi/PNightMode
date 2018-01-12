package com.muzi.support.nightmode;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by linpu on 17-12-21.
 */

public class NightModeActivityManager {

    private List<BaseAppCompatActivity> mActivityList;

    private NightModeActivityManager() {
        mActivityList = Collections.synchronizedList(new ArrayList<BaseAppCompatActivity>());
    }

    private final static class Holder {
        private final static NightModeActivityManager sInstance = new NightModeActivityManager();
    }

    public static NightModeActivityManager getInstance() {
        return Holder.sInstance;
    }

    public void addAppCompatActivity(Activity activity) {
        if (activity != null && activity instanceof BaseAppCompatActivity) {
            mActivityList.add((BaseAppCompatActivity) activity);
        }
    }

    public void removeAppCompatActivity(Activity activity) {
        if (activity != null && activity instanceof BaseAppCompatActivity) {
            mActivityList.remove((BaseAppCompatActivity) activity);
        }
    }

    public List<BaseAppCompatActivity> getActivityList() {
        return mActivityList;
    }

}
