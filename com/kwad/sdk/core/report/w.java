package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/w.class */
public final class w {
    private static Context Op;
    private static String ajS = xl();
    private static long ajT = 0;

    private static long aV(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }

    private static boolean d(Context context, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
            edit.putLong("seq", j);
            return edit.commit();
        }
        return false;
    }

    public static void init(Context context) {
        Op = context;
    }

    public static String xh() {
        com.kwad.sdk.core.d.b.d("ReportIdManager", ">> updateSessionId");
        String xl = xl();
        ajS = xl;
        return xl;
    }

    public static String xi() {
        return ajS;
    }

    public static long xj() {
        long aV = aV(Op);
        d(Op, 1 + aV);
        return aV;
    }

    public static long xk() {
        return ajT;
    }

    private static String xl() {
        return UUID.randomUUID().toString();
    }
}
