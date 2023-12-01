package com.blued.android.framework.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.blued.android.core.AppInfo;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/KeyboardUtils.class */
public class KeyboardUtils {
    private static int a;
    private static int b;

    public static int a() {
        if (b == 0) {
            b = (int) (AppInfo.m * 0.4f);
        }
        if (a == 0 && AppInfo.d() != null) {
            a = AppInfo.d().getSharedPreferences("sp_keyboard", 0).getInt("keyboard_height", b);
        }
        int i = a;
        return i != 0 ? i : b;
    }

    public static void a(int i) {
        if (a != i) {
            a = i;
            if (AppInfo.d() != null) {
                AppInfo.d().getSharedPreferences("sp_keyboard", 0).edit().putInt("keyboard_height", i).commit();
            }
        }
    }

    public static void a(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager == null || !inputMethodManager.isActive() || activity.getCurrentFocus() == null || activity.getCurrentFocus().getWindowToken() == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInputFromInputMethod(view.getWindowToken(), 0);
    }

    public static void a(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 2);
    }

    public static void b(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void b(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean b(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                return inputMethodManager.isActive();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void c(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager == null || !inputMethodManager.isActive()) {
                return;
            }
            inputMethodManager.toggleSoftInput(0, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
