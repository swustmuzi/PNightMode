package com.muzi.nightmode.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.muzi.nightmode.R;
import com.muzi.nightmode.util.reflection.AndroidInternalR_R;

import java.lang.reflect.Field;

/**
 * Created by linpu on 18-1-12.
 */

public class ThemeUtils {

    public static final int[] STYLEABLE_ARRAY_View = AndroidInternalR_R.styleable.View;
    public static final int STYLEABLE_View_background = AndroidInternalR_R.styleable.View_background;
    public static final int STYLEABLE_View_paddingLeft = AndroidInternalR_R.styleable.View_paddingLeft;
    public static final int STYLEABLE_View_alpha = AndroidInternalR_R.styleable.View_alpha;
    public static final int[] STYLEABLE_ARRAY_TextView = AndroidInternalR_R.styleable.TextView;
    public static final int STYLEABLE_TextView_textSize = AndroidInternalR_R.styleable.TextView_textSize;
    public static final int STYLEABLE_TextView_textColor = AndroidInternalR_R.styleable.TextView_textColor;
    public static final int STYLEABLE_TextView_textColorHint = AndroidInternalR_R.styleable.TextView_textColorHint;
    public static final int STYLEABLE_TextView_textCursorDrawable = AndroidInternalR_R.styleable.TextView_textCursorDrawable;
    public static final int STYLEABLE_TextView_privateImeOptions = AndroidInternalR_R.styleable.TextView_privateImeOptions;


    /**
     * STYLEABLE_ARRAY_View 是 View 的属性集合，通过反射获取到 com.android.internal.R$styleable 类，
     * 再通过该类获取到其内部与 View 相关的 attr 属性，com.android.internal.R 中除了 styleable 外，还包含了其它的类
     * 包括 attr/id/string/style/styleable，都可以通过反射来获取。
     *
     * @param v 需要应用属性的 View。
     * @param styleId 主题的 styleId，对应 theme_default/theme_custom 的主题。
     *
     */
    public static void applyStyle_View(View v, int styleId) {
        TypedArray a = v.getContext().getTheme().obtainStyledAttributes(styleId,
                STYLEABLE_ARRAY_View);
        int N = a.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = a.getIndex(i);
            if (attr == STYLEABLE_View_background) {
                Drawable backgroundDr = a.getDrawable(attr);
                v.setBackground(backgroundDr);
            } else if (attr == STYLEABLE_View_paddingLeft) {
                v.setPadding(a.getDimensionPixelOffset(attr, 0), v.getPaddingTop(), v.getPaddingRight(), v.getPaddingBottom());
            } else if (attr == STYLEABLE_View_alpha) {
                v.setAlpha(a.getFloat(attr, 1));
            }
        }
        a.recycle();
    }

    public static void applyStyle_TextView(TextView v, int styleId) {
        TypedArray a = v.getContext().getTheme().obtainStyledAttributes(styleId,
                STYLEABLE_ARRAY_TextView);
        int N = a.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = a.getIndex(i);
            if (attr == STYLEABLE_TextView_textSize) {
                int textSize = a.getDimensionPixelSize(attr, 0);
                if (textSize != 0) {
                    v.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                }
            } else if (attr == STYLEABLE_TextView_textColor) {
                ColorStateList textColor = a.getColorStateList(attr);
                v.setTextColor(textColor);
            } else if (attr == STYLEABLE_TextView_textColorHint) {
                ColorStateList textColorHint = a.getColorStateList(attr);
                v.setHintTextColor(textColorHint);
            } else if (attr == STYLEABLE_TextView_privateImeOptions) {
                String imeOpt = a.getString(attr);
                v.setPrivateImeOptions(imeOpt);
            } else if(attr == STYLEABLE_TextView_textCursorDrawable){
                int  mCursorDrawableRes = a.getResourceId(attr, 0);
                if(mCursorDrawableRes != 0){
                    setCursorDrawable(v,mCursorDrawableRes);
                }
            }
        }
        a.recycle();
    }

    /**
     * 设置光标颜色
     *
     * @param cursorDrawableRes
     */
    private static Field sCursorDrawableRes = null;
    private static Field sEditor = null;
    private static Field sCursorDrawable = null;
    public static void setCursorDrawable(TextView v, int cursorDrawableRes) {
        try {
            if (sCursorDrawableRes == null) {
                sCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
                sCursorDrawableRes.setAccessible(true);
            }
            sCursorDrawableRes.set(v, cursorDrawableRes);
            v.invalidate();
            if (sEditor == null) {
                sEditor = TextView.class.getDeclaredField("mEditor");
                sEditor.setAccessible(true);
            }
            Object editor = sEditor.get(v);
            if(editor != null){
                if (sCursorDrawable == null) {
                    Class<?> clazz = editor.getClass();
                    sCursorDrawable = clazz.getDeclaredField("mCursorDrawable");
                    sCursorDrawable.setAccessible(true);
                }
                Drawable cursorDrawable = v.getContext().getResources().getDrawable(cursorDrawableRes);
                sCursorDrawable.set(editor, cursorDrawable);
            }
        } catch (Exception ignored) {
        }
    }

    /**
     * 解析 xml 中的标签，将获得到的白天/夜间模式的主题 Id 赋值给 defaultAndCustomTheme 数组，数组[0] 对应
     * 白天模式的 Id，数组[1] 对应夜间模式的 ID。
     * @param context
     * @param attrs
     * @param defStyle
     * @param defaultAndNightTheme
     * @return
     */
    public static boolean getTheme_BrowserView(Context context, AttributeSet attrs,
                                               int defStyle, int[] defaultAndNightTheme) {
        /**
         *
         * 第一种情况：
         * 从这里开始到 a.recycle() 方法，适用于在 xml 中以下列方式声明的属性
         * -----------
         * self:theme_default="@style/sampleStyleDay"
         * self:theme_night="@style/sampleStyleNight"
         * -----------
         *
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.DayNightTheme, defStyle, 0);
        int theme_default = a.getResourceId(R.styleable.DayNightTheme_theme_default, 0);
        int theme_night = a.getResourceId(R.styleable.DayNightTheme_theme_night, 0);
        a.recycle();

        /**
         *
         * 第二种情况：
         * 如果在布局文件 xml 标签中没有全部声明 theme_default 和 theme_night，那么会尝试读取 dayNightStyle 声明的属性
         * （这也是我们最常使用的方式）
         *
         * -----------
         * <! -- 布局文件 xml 中声明 dayNightStyle 属性，它是一个 style，在 style.xml 中定义  -->
         * self:dayNightStyle="@style/sampleStyle"
         *
         * <!- style.xml 中的声明 -->
         * <style name="sampleStyleDay">
         *      <item name="android:background">#ffffff</item>
         * </style>
         * <style name="sampleStyleNight">
         *      <item name="android:background">#99ffffff</item>
         * </style>
         * <style name="sampleStyle">
         *      <item name="theme_default">@style/sampleStyleDay</item>
         *      <item name="theme_custom">@style/sampleStyleNight</item>
         * </style>
         * -----------
         * 解析分为两个步骤：
         * (1) 先解析 self:dayNightStyle 中的属性，它指向 sampleStyle 引用
         * (2) 从 sampleStyle 分别获取 sampleStyleDay 和 sampleStyleNight 这两个白天/夜间模式的主题。
         *
         */
        if (theme_default == 0 || theme_night == 0) {
            a = context.getTheme().obtainStyledAttributes(attrs,
                    new int[]{R.attr.dayNightStyle}, defStyle, 0);
            int themeRef = a.getResourceId(0, 0);
            a.recycle();
            if (themeRef != 0) {
                a = context.getTheme().obtainStyledAttributes(themeRef,
                        R.styleable.DayNightTheme);
                if (theme_default == 0) {
                    theme_default = a.getResourceId(R.styleable.DayNightTheme_theme_default, 0);
                }
                if (theme_night == 0) {
                    theme_night = a.getResourceId(R.styleable.DayNightTheme_theme_night, 0);
                }
                a.recycle();
            }
        }

        defaultAndNightTheme[0] = theme_default;
        defaultAndNightTheme[1] = theme_night;
        return theme_default != 0 || theme_night != 0;
    }

}
