package com.muzi.nightmode.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.muzi.nightmode.util.CommonSettings;
import com.muzi.nightmode.util.ThemeUtils;

import java.util.HashMap;

/**
 * Created by linpu on 18-1-12.
 */

public class DayNightTextView extends TextView implements DayNightThemeInterface{

    private String mCurrentTheme;
    private HashMap<String, Integer> mThemeSet = new HashMap<String, Integer>(5);

    public DayNightTextView(Context context) {
        super(context);
    }

    public DayNightTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DayNightTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        ThemeUtils.applyStyle_TextView(this, 0);
        int[] defaultAndCustomTheme = new int[] {0, 0};
        if (ThemeUtils.getTheme_BrowserView(context, attrs, defStyle, defaultAndCustomTheme)) {
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
