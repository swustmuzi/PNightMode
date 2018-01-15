package com.muzi.nightmode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.muzi.nightmode.util.CommonSettings;
import com.muzi.nightmode.widget.DayNightThemeInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnToggleNightMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyActivityTheme(CommonSettings.isNightMode());
        setContentView(R.layout.activity_main);

        mBtnToggleNightMode = (Button) findViewById(R.id.btn_mode_toggle);
        mBtnToggleNightMode.setOnClickListener(this);
    }

    private void applyActivityTheme(boolean isNight) {
        getTheme().applyStyle(isNight ? R.style.AppThemeNight : R.style.AppThemeDay, true);
    }

    private void applyViewTheme(View view, String currentTheme) {
        if (view == null) {
            return;
        }
        if (view instanceof DayNightThemeInterface) {
            ((DayNightThemeInterface) view).applyTheme(currentTheme);
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup)view;
            for (int i = 0, count = group.getChildCount(); i < count; i++) {
                applyViewTheme(group.getChildAt(i), currentTheme);
            }
        }
    }

    private void toggleNightMode(boolean isNight) {
        applyActivityTheme(isNight);
        View rootView = mBtnToggleNightMode.getRootView();
        String currentTheme = CommonSettings.getCurrentTheme();
        applyViewTheme(rootView, currentTheme);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_mode_toggle:
                boolean currentNightMode = CommonSettings.isNightMode();
                CommonSettings.setNightMode(!currentNightMode);
                toggleNightMode(!currentNightMode);
                break;
            default:
                break;
        }
    }
}
