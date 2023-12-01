package com.tencent.map.geolocation;

import android.content.Context;
import c.t.m.g.f6;
import c.t.m.g.y5;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/geolocation/TencentLocationUtils.class */
public class TencentLocationUtils {
    public TencentLocationUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean contains(TencentLocation tencentLocation, double d, TencentLocation tencentLocation2) {
        if (tencentLocation == null || tencentLocation2 == null) {
            throw null;
        }
        return distanceBetween(tencentLocation, tencentLocation2) <= d;
    }

    public static double distanceBetween(double d, double d2, double d3, double d4) {
        return f6.a(d, d2, d3, d4);
    }

    public static double distanceBetween(TencentLocation tencentLocation, TencentLocation tencentLocation2) {
        if (tencentLocation == null || tencentLocation2 == null) {
            throw null;
        }
        return f6.a(tencentLocation.getLatitude(), tencentLocation.getLongitude(), tencentLocation2.getLatitude(), tencentLocation2.getLongitude());
    }

    public static boolean isFromGps(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return false;
        }
        return "gps".equals(tencentLocation.getProvider());
    }

    public static boolean isFromNetwork(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return false;
        }
        return "network".equals(tencentLocation.getProvider());
    }

    public static boolean isSupportGps(Context context) {
        if (context != null) {
            return (y5.a().a(context) & 16) == 0;
        }
        throw null;
    }
}
