package com.blued.android.module.shortvideo.utils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvLogUtils.class */
public class StvLogUtils {
    public static void a(int i) {
        try {
            AppMethods.a((CharSequence) AppInfo.d().getResources().getString(i), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            AppMethods.a((CharSequence) str, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(String str, Object... objArr) {
    }

    public static void b(String str, Object... objArr) {
    }

    public static void c(String str, Object... objArr) {
    }

    public static void d(String str, Object... objArr) {
    }
}
