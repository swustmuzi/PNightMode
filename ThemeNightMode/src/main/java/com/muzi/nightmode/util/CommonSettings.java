package com.muzi.nightmode.util;

import com.muzi.nightmode.widget.DayNightThemeInterface;

/**
 * Created by linpu on 18-1-12.
 */

public class CommonSettings {

    public static boolean isNightMode() {
        return false;
    }

    public static String getCurrentTheme() {
        boolean isNightMode = isNightMode();
        return isNightMode ? DayNightThemeInterface.THEME_NIGHT : DayNightThemeInterface.THEME_DEFAULT;
    }

}
