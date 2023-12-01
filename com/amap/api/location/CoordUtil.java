package com.amap.api.location;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/location/CoordUtil.class */
public class CoordUtil {
    private static boolean a = false;

    public static native int convertToGcj(double[] dArr, double[] dArr2);

    public static boolean isLoadedSo() {
        return a;
    }

    public static void setLoadedSo(boolean z) {
        a = z;
    }
}
