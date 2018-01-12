package com.muzi.nightmode.util.reflection;

import android.app.Activity;
import android.util.Log;

public class AndroidInternalR_R {
    private static final String TAG = "AndroidInternalR_R";
    private static final String ERROR_TAG = "ReflectError " + TAG;

    public static class attr {
        private static final Class<?> sClassAttr = getAttrClass();
        public static int expandableListViewStyle;
        public static int autoCompleteTextViewStyle;
        public static int listPopupWindowStyle;
        public static int yesNoPreferenceStyle;

        static {
            try {
                expandableListViewStyle = sClassAttr.getField("expandableListViewStyle").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                autoCompleteTextViewStyle = sClassAttr.getField("autoCompleteTextViewStyle").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                listPopupWindowStyle = sClassAttr.getField("listPopupWindowStyle").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                yesNoPreferenceStyle = sClassAttr.getField("yesNoPreferenceStyle").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
        }

        private static Class<?> getAttrClass() {
            try {
                Class<?> clz = Class.forName("com.android.internal.R$attr");
                return clz;
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            return null;
        }
    }

    public static class styleable {
        private static final Class<?> sClassStyleable = getStyleableClass();

        public static int[] Theme;
        public static int[] AlertDialog;
        public static int Theme_dividerVertical;
        public static int PopupWindow_popupBackground;
        public static int AlertDialog_singleChoiceItemLayout;
        public static int[] View;
        public static int View_background;
        public static int View_paddingLeft;
        public static int View_alpha;
        public static int[] TextView;
        public static int TextView_textSize;
        public static int TextView_textColor;
        public static int TextView_textColorHint;
        public static int TextView_privateImeOptions;
        public static int[] ImageView;
        public static int ImageView_src;
        public static int[] ProgressBar;
        public static int ProgressBar_progressDrawable;
        public static int[] AbsListView;
        public static int AbsListView_listSelector;
        public static int[] ListView;
        public static int ListView_divider;
        public static int ListView_dividerHeight;
        public static int[] Spinner;
        public static int Spinner_popupBackground;
        public static int[] PopupWindow;
        public static int[] ListPreference;
        public static int TextView_textCursorDrawable;

        static {
            try {
                Theme = (int[]) sClassStyleable.getField("Theme").get(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                AlertDialog = (int[]) sClassStyleable.getField("AlertDialog").get(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                Theme_dividerVertical = sClassStyleable.getField("Theme_dividerVertical").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                PopupWindow_popupBackground = sClassStyleable.getField("PopupWindow_popupBackground").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                AlertDialog_singleChoiceItemLayout = sClassStyleable.getField("AlertDialog_singleChoiceItemLayout").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                View = (int[]) sClassStyleable.getField("View").get(null);

            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                View_background = sClassStyleable.getField("View_background").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                View_paddingLeft = sClassStyleable.getField("View_paddingLeft").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                View_alpha = sClassStyleable.getField("View_alpha").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                TextView = (int[]) sClassStyleable.getField("TextView").get(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                TextView_textSize = sClassStyleable.getField("TextView_textSize").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                TextView_textColor = sClassStyleable.getField("TextView_textColor").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }

            try {
                TextView_textCursorDrawable = sClassStyleable.getField("TextView_textCursorDrawable").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                TextView_textColorHint = sClassStyleable.getField("TextView_textColorHint").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                TextView_privateImeOptions = sClassStyleable.getField("TextView_privateImeOptions").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                ImageView = (int[]) sClassStyleable.getField("ImageView").get(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                ImageView_src = sClassStyleable.getField("ImageView_src").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                ProgressBar = (int[]) sClassStyleable.getField("ProgressBar").get(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                ProgressBar_progressDrawable = sClassStyleable.getField("ProgressBar_progressDrawable").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                AbsListView = (int[]) sClassStyleable.getField("AbsListView").get(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                AbsListView_listSelector = sClassStyleable.getField("AbsListView_listSelector").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                ListView = (int[]) sClassStyleable.getField("ListView").get(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                ListView_divider = sClassStyleable.getField("ListView_divider").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                ListView_dividerHeight = sClassStyleable.getField("ListView_dividerHeight").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }


            try {
                Spinner = (int[]) sClassStyleable.getField("Spinner").get(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                Spinner_popupBackground = sClassStyleable.getField("Spinner_popupBackground").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                PopupWindow = (int[]) sClassStyleable.getField("PopupWindow").get(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                ListPreference = (int[]) sClassStyleable.getField("ListPreference").get(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
        }

        private static Class<?> getStyleableClass() {
            try {
                Class<?> clz = Class.forName("com.android.internal.R$styleable");
                return clz;
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            return null;
        }

    }

    public static class id {
        private static final Class<?> sClassId = getIdClass();

        public static int action_bar;
        public static int placeholder;
        public static int startSelectingText;

        static {
            try {
                action_bar = sClassId.getField("action_bar").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                placeholder = sClassId.getField("placeholder").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            try {
                startSelectingText = sClassId.getField("startSelectingText").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
        }

        private static Class<?> getIdClass() {
            try {
                Class<?> clz = Class.forName("com.android.internal.R$id");
                return clz;
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            return null;
        }
    }

    public static class string {
        private static final Class<?> sClassString = getStringClass();
        public static int reason_unknown;

        static {
            try {
                reason_unknown = sClassString.getField("reason_unknown").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
        }

        private static Class<?> getStringClass() {
            try {
                Class<?> clz = Class.forName("com.android.internal.R$string");
                return clz;
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            return null;
        }
    }

    public static class style {
        private static final Class<?> sClassStyle = getStyleClass();
        public static int Animation_DropDownUp;

        static {
            try {
                Animation_DropDownUp = sClassStyle.getField("Animation_DropDownUp").getInt(null);
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
        }

        private static Class<?> getStyleClass() {
            try {
                Class<?> clz = Class.forName("com.android.internal.R$style");
                return clz;
            } catch (Exception e) {
                Log.w(ERROR_TAG, "", e);
            }
            return null;
        }
    }


    public static void doTest(Activity activity) {
        int i = string.reason_unknown;
        i = attr.autoCompleteTextViewStyle;
        i = styleable.AbsListView_listSelector;
        i = id.action_bar;
        i = style.Animation_DropDownUp;
    }
}
