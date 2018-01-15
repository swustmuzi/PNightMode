package com.muzi.nightmode.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.muzi.nightmode.R;
import com.muzi.nightmode.util.CommonSettings;
import com.muzi.nightmode.util.ThemeUtils;

import java.util.HashMap;

/**
 * Created by linpu on 18-1-15.
 */

public class DayNightLinearLayout extends LinearLayout implements DayNightThemeInterface{

    private String mCurrentTheme;
    private HashMap<String, Integer> mThemeSet = new HashMap<String, Integer>(5);

    public DayNightLinearLayout(Context context) {
        super(context);
        init(context, null, 0);
    }

    public DayNightLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, R.attr.dayNightStyle);
    }

    public DayNightLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        ThemeUtils.applyStyle_View(this, 0);
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
        }
    }

    @Override
    public void addTheme(String whichTheme, int styleId) {
        mThemeSet.put(whichTheme, styleId);
    }
}
