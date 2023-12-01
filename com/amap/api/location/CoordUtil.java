package com.amap.api.location;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/location/CoordUtil.class */
public class CoordUtil {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5485a = false;

    public static native int convertToGcj(double[] dArr, double[] dArr2);

    public static boolean isLoadedSo() {
        return f5485a;
    }

    public static void setLoadedSo(boolean z) {
        f5485a = z;
    }
}
