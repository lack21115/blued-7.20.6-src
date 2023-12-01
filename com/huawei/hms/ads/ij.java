package com.huawei.hms.ads;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ij.class */
public class ij {
    public static final int B = 100;
    public static final int Code = 0;
    public static final int I = 50;
    public static final int V = 25;
    public static final int Z = 75;

    public static int Code(float f, float f2) {
        if (f2 < 75.0f || f >= 75.0f) {
            if (f2 < 50.0f || f >= 50.0f) {
                return (f2 < 25.0f || f >= 25.0f) ? 0 : 25;
            }
            return 50;
        }
        return 75;
    }
}
