package com.tencent.liteav.base.util;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/TimeUtil.class */
public class TimeUtil {
    public static long a() {
        return nativeGetTimeTick();
    }

    public static long b() {
        return nativeGetUtcTimeTick();
    }

    public static long c() {
        return nativeGetTimestamp();
    }

    private static native long nativeGetTimeTick();

    private static native long nativeGetTimestamp();

    private static native long nativeGetUtcTimeTick();
}
