package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/cfg/MultiProcessFlag.class */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f14174a;
    private static boolean b;

    public static boolean isMultiProcess() {
        return f14174a;
    }

    public static void setMultiProcess(boolean z) {
        if (b) {
            GDTLogger.w("MultiProcessFlag已经设置过，再次设置无效");
            return;
        }
        b = true;
        f14174a = z;
    }
}
