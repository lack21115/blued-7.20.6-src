package com.blued.android.framework.utils;

import android.content.Context;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/UiUtils.class */
public class UiUtils {
    private UiUtils() {
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
