package com.tencent.liteav.videobase.common;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/common/b.class */
public enum b {
    UNKNOWN(0),
    BASELINE(1),
    MAIN(2),
    HIGH(3),
    BASELINE_RPS(4),
    MAIN_RPS(5),
    HIGH_RPS(6);
    
    private static final b[] h = values();
    public final int mValue;

    b(int i2) {
        this.mValue = i2;
    }

    public static b a(int i2) {
        b[] bVarArr = h;
        int length = bVarArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return UNKNOWN;
            }
            b bVar = bVarArr[i4];
            if (bVar.mValue == i2) {
                return bVar;
            }
            i3 = i4 + 1;
        }
    }
}
