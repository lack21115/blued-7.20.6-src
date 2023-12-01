package com.blued.android.module.common.utils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/ToastUtils.class */
public class ToastUtils {
    public static void a(int i) {
        try {
            AppMethods.a((CharSequence) AppInfo.d().getResources().getString(i), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            AppMethods.a((CharSequence) str, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(int i) {
        try {
            AppMethods.a((CharSequence) AppInfo.d().getResources().getString(i), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            AppMethods.a((CharSequence) str, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
