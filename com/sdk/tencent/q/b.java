package com.sdk.tencent.q;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/q/b.class */
public class b {
    public static boolean a(Context context) {
        Long b = com.sdk.tencent.j.a.b(context, "access_limit_time");
        long currentTimeMillis = System.currentTimeMillis();
        if (b == null) {
            com.sdk.tencent.j.a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
            return true;
        } else if (currentTimeMillis - b.longValue() > 600000) {
            com.sdk.tencent.j.a.a(context, "access_limit_time", Long.valueOf(currentTimeMillis));
            com.sdk.tencent.j.a.a(context, "access_limit_count", (Long) 0L);
            return true;
        } else {
            Long b2 = com.sdk.tencent.j.a.b(context, "access_limit_count");
            if (b2 != null) {
                return b2.longValue() <= 30;
            }
            com.sdk.tencent.j.a.a(context, "access_limit_count", (Long) 0L);
            return true;
        }
    }

    public static void b(Context context) {
        Long b = com.sdk.tencent.j.a.b(context, "access_limit_count");
        com.sdk.tencent.j.a.a(context, "access_limit_count", Long.valueOf(b == null ? 0L : b.longValue() + 1));
    }
}
