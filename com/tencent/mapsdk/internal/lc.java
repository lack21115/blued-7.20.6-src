package com.tencent.mapsdk.internal;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/lc.class */
public class lc extends ic {

    /* renamed from: c  reason: collision with root package name */
    private static volatile lc f37620c;
    private static final String d = "com.tencent.tencentmap.mapsdk.maps.offlinemap";

    private lc(Context context) {
        if (context == null) {
            return;
        }
        this.f37553a = context.getSharedPreferences(d, 0);
        c();
    }

    public static lc a(Context context) {
        if (f37620c == null) {
            synchronized (lc.class) {
                try {
                    if (f37620c == null) {
                        f37620c = new lc(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f37620c;
    }

    private void c() {
        if (f37620c == null) {
            return;
        }
        a(new String[]{"taiwanClearCacheVersion", "taiwanStyle", "taiwanVersion", "mapPoiIcon", "worldTileCount", "rttConfigVersion", "rttConfigMd5", "closeRoadSytleNomalModeVersion", "closeRoadSytleNomalModeMd5", "closeRoadStyleTrafficModeVersion", "closeRoadStyleTrafficModeMd5", "offlineCityListVersion", "offlineCityListMd5"});
        String d2 = d("sdkVersion");
        if (d2 != null && c7.b("4.1.0", d2) > 0) {
            b();
        }
    }
}
