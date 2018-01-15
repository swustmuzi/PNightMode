package com.muzi.nightmode.widget;

/**
 * Created by linpu on 18-1-12.
 */

public interface DayNightThemeInterface {

    static final String THEME_NIGHT = "night"; //现用于夜间模式。
    static final String THEME_DEFAULT = "default"; //普通模式。
    void applyTheme(String whichTheme);
    void addTheme(String whichTheme, int styleId);

}
