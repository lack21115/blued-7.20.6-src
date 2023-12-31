package com.meizu.cloud.pushsdk.c.h;

import android.net.TrafficStats;
import com.meizu.cloud.pushsdk.c.a.e;
import com.meizu.cloud.pushsdk.c.c.k;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/h/a.class */
public final class a {
    public static void a(k kVar, com.meizu.cloud.pushsdk.c.a.b bVar) {
        if (bVar.f() == e.OK_HTTP_RESPONSE || kVar == null || kVar.b() == null) {
            return;
        }
        try {
            if (kVar.b().a() != null) {
                try {
                    kVar.b().a().close();
                    if (!MinSdkChecker.isSupportNotificationChannel()) {
                        return;
                    }
                } catch (Exception e) {
                    com.meizu.cloud.pushsdk.c.a.a.a("Unable to close source data");
                    if (!MinSdkChecker.isSupportNotificationChannel()) {
                        return;
                    }
                }
                TrafficStats.clearThreadStatsTag();
            }
        } catch (Throwable th) {
            if (MinSdkChecker.isSupportNotificationChannel()) {
                TrafficStats.clearThreadStatsTag();
            }
            throw th;
        }
    }
}
