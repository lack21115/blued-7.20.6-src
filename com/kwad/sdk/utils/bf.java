package com.kwad.sdk.utils;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bf.class */
public final class bf {
    public static void a(long j, int i, Context context) {
        if (j == 0 || context == null || i <= 0 || i > 100) {
            return;
        }
        long currentTimeMillis = j - System.currentTimeMillis();
        (Math.abs(currentTimeMillis) / 3600000 > ((long) i) ? context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong("key_time_diff_s2c", currentTimeMillis) : context.getSharedPreferences("ksadsdk_pref", 0).edit().remove("key_time_diff_s2c")).apply();
    }

    public static long v(Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (context != null) {
                long j = context.getSharedPreferences("ksadsdk_pref", 0).getLong("key_time_diff_s2c", 0L);
                if (j != 0) {
                    return currentTimeMillis + j;
                }
            }
            return Math.abs(currentTimeMillis);
        }
        return currentTimeMillis;
    }
}
