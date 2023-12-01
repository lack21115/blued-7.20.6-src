package com.tencent.liteav.videobase.common;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/common/a.class */
public enum a {
    UNKNOWN(65535),
    IDR(0),
    P(1),
    B(2),
    SEI(3),
    I(4),
    P_MULTI_REF(5),
    SPS(18),
    PPS(19),
    VPS(20);
    
    private static final a[] k = values();
    public final int mValue;

    a(int i) {
        this.mValue = i;
    }

    public static a a(int i) {
        a[] aVarArr = k;
        int length = aVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return UNKNOWN;
            }
            a aVar = aVarArr[i3];
            if (aVar.mValue == i) {
                return aVar;
            }
            i2 = i3 + 1;
        }
    }
}
