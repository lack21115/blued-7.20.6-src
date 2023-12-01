package com.tencent.tencentmap.lbssdk.service;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/lbssdk/service/GTime.class */
public class GTime {
    public double sec;
    public long time;

    public GTime() {
        this(0L, 0.0d);
    }

    public GTime(long j, double d) {
        setGTime(j, d);
    }

    public static native double jni_getCurrSow();

    public static native double jni_getCurrUTC();

    public static native double jni_getGpsTow();

    public static native int jni_getGpsWeek();

    public static native long jni_getUtcTimeMillis();

    public void copyTo(GTime gTime) {
        if (gTime == null) {
            throw new IllegalArgumentException();
        }
        gTime.setGTime(this.time, this.sec);
    }

    public long getGpsTimeMillis() {
        return (this.time * 1000) + Math.round(this.sec * 1000.0d);
    }

    public void setGTime(long j, double d) {
        this.time = j;
        this.sec = d;
    }
}
