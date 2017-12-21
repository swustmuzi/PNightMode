package com.muzi.support.nightmode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

public class BaseAppCompatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.base_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_day:
                toggleNightModeForAllActivities(AppCompatDelegate.MODE_NIGHT_NO);
                return true;
            case R.id.action_night:
                toggleNightModeForAllActivities(AppCompatDelegate.MODE_NIGHT_YES);
                return true;
            case R.id.action_auto:
                toggleNightModeForAllActivities(AppCompatDelegate.MODE_NIGHT_AUTO);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void toggleNightModeForAllActivities(int mode) {
        List<BaseAppCompatActivity> list = NightModeActivityManager.getInstance().getActivityList();
        if (list != null && list.size() > 0) {
            for (BaseAppCompatActivity activity : list) {
                activity.toggleGlobalNightMode(mode);
            }
        }
    }

    protected void toggleGlobalNightMode(int mode) {
        AppCompatDelegate.setDefaultNightMode(mode);
        recreate();
    }

    protected void toggleLocalNightMode(int mode) {
        getDelegate().setLocalNightMode(mode);
        recreate();
    }

}
