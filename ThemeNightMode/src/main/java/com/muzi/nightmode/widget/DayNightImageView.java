package com.muzi.nightmode.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.muzi.nightmode.R;
import com.muzi.nightmode.util.CommonSettings;
import com.muzi.nightmode.util.ThemeUtils;

import java.util.HashMap;

/**
 * Created by linpu on 18-1-15.
 */

public class DayNightImageView extends ImageView implements DayNightThemeInterface{
    private String mCurrentTheme;
    private HashMap<String, Integer> mThemeSet = new HashMap<String, Integer>(5);
    private boolean mMask;
    private int mMaskColor;


    public DayNightImageView(Context context) {
        super(context);
        init(context, null, 0);
    }
    public DayNightImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }
    public DayNightImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        mMaskColor = getResources().getColor(R.color.imageview_mask_default_night);

        /**
         * 解析为 ImageView 特殊定义的属性，每个需要实现白天/夜间模式的 View 需要定义的不同，不可以直接拷贝。
         */
        ThemeUtils.applyStyle_DayNightImageView(this, attrs, 0);

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
            ThemeUtils.applyStyle_ImageView(this, styleId);
            ThemeUtils.applyStyle_DayNightImageView(this, null, styleId);
        }
    }

    @Override
    public void addTheme(String whichTheme, int styleId) {
        mThemeSet.put(whichTheme, styleId);
    }

    public void setMaskEnable(boolean mask) {
        if (mMask == mask) {
            return;
        }
        mMask = mask;
        if (mMask) {
            // 蒙灰处理
            setColorFilter(mMaskColor);
        } else {
            clearColorFilter();
        }
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if(null != drawable) {
            drawable.setColorFilter(getColorFilter());
        }
    }

}
