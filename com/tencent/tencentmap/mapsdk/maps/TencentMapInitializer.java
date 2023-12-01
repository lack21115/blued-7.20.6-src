package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import com.tencent.mapsdk.internal.g7;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/TencentMapInitializer.class */
public final class TencentMapInitializer {
    private static volatile boolean agreePrivacy = false;

    public static boolean getAgreePrivacy() {
        boolean z;
        synchronized (TencentMapInitializer.class) {
            try {
                z = agreePrivacy;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static String getDuid(Context context) {
        synchronized (TencentMapInitializer.class) {
            try {
                if (agreePrivacy) {
                    return g7.e(context);
                }
                return "undefined";
            } finally {
            }
        }
    }

    public static String getSuid(Context context) {
        synchronized (TencentMapInitializer.class) {
            try {
                if (agreePrivacy) {
                    return g7.h(context);
                }
                return "undefined";
            } finally {
            }
        }
    }

    public static void setAgreePrivacy(boolean z) {
        synchronized (TencentMapInitializer.class) {
            try {
                agreePrivacy = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
