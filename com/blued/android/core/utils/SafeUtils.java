package com.blued.android.core.utils;

import com.blued.android.core.AppInfo;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/SafeUtils.class */
public class SafeUtils {
    public static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            if (AppInfo.m()) {
                throw e;
            }
            return -1;
        }
    }
}
