package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/utils/e.class */
public final class e {
    private static Context Op;

    private static long aV(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("crashseq", 1L);
    }

    private static boolean d(Context context, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
            edit.putLong("crashseq", j);
            return edit.commit();
        }
        return false;
    }

    public static void init(Context context) {
        Op = context;
    }

    public static long xj() {
        long aV = aV(Op);
        d(Op, 1 + aV);
        return aV;
    }
}
