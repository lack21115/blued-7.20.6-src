package com.tencent.map.geolocation.walkBikeDr.dr;

import c.t.m.g.g3;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/geolocation/walkBikeDr/dr/TencentDrJni.class */
public class TencentDrJni {
    public static native void a(long j, float f, float f2, float f3, long j2, float f4, float f5, float f6, long j3, float f7, float f8, float f9, long j4, float f10, float f11, float f12);

    public static native void e();

    public static native void g(String str, boolean z);

    public static native double[] gp();

    public static native String gv();

    public static void logToCoreLog(String str, String str2) {
        g3.a(3, str, str2);
    }

    public static native void s();

    public static native void sa(int i, double d);

    public static native void sg(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    public static native void sn(long j, long j2, double d, double d2, int i);

    public static native void sr(double[][] dArr, int i);

    public static native void ss(int i, double d);
}
