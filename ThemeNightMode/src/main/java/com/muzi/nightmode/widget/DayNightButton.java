package com.muzi.nightmode.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.muzi.nightmode.util.CommonSettings;
import com.muzi.nightmode.util.ThemeUtils;

import java.util.HashMap;

/**
 * Created by linpu on 18-1-15.
 */

public class DayNightButton extends Button implements DayNightThemeInterface{

    private String mCurrentTheme;
    private HashMap<String, Integer> mThemeSet = new HashMap<String, Integer>(5);
    public DayNightButton(Context context) {
        super(context);
        init(context, null, 0);
    }
    public DayNightButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }
    public DayNightButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        int[] defaultAndCustomTheme = new int[] {0, 0};
        if (ThemeUtils.getTheme_DayNightView(context, attrs, defStyle, defaultAndCustomTheme)) {
            addTheme(THEME_DEFAULT, defaultAndCustomTheme[0]);
            addTheme(THEME_NIGHT, defaultAndCustomTheme[1]);
            applyTheme(CommonSettings.getCurrentTheme());
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        applyTheme(CommonSettings.getCurrentTheme());
    }

    @Override
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        applyTheme(CommonSettings.getCurrentTheme());
    }

    @Override
    public void applyTheme(String whichTheme) {
        if (whichTheme.equals(mCurrentTheme)) {
            return;
        }
        mCurrentTheme = whichTheme;
        int styleId = 0;
        Integer tmp = mThemeSet.get(mCurrentTheme);
        if (tmp != null && tmp != 0) {
            styleId = tmp;
        }
        if (styleId != 0) {
            ThemeUtils.applyStyle_View(this, styleId);
            ThemeUtils.applyStyle_TextView(this, styleId);
        }
    }

    @Override
    public void addTheme(String whichTheme, int styleId) {
        mThemeSet.put(whichTheme, styleId);
    }

}
