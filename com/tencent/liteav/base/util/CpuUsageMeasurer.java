package com.tencent.liteav.base.util;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/CpuUsageMeasurer.class */
public class CpuUsageMeasurer {
    public static int[] a() {
        int[] nativeGetCpuUsage = nativeGetCpuUsage();
        return new int[]{nativeGetCpuUsage[0], nativeGetCpuUsage[1]};
    }

    public static native int[] nativeGetCpuUsage();
}
