package com.muzi.nightmode.widget;

/**
 * Created by linpu on 18-1-12.
 */

public interface DayNightThemeInterface {

    public static final String THEME_NIGHT = "night"; //现用于夜间模式。
    public static final String THEME_DEFAULT = "default"; //普通模式。
    public void applyTheme(String whichTheme);
    public void addTheme(String whichTheme, int styleId);

}
