package com.android.org.conscrypt.util;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/util/Arrays.class */
public final class Arrays {
    private Arrays() {
    }

    public static final void checkOffsetAndCount(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            throw new ArrayIndexOutOfBoundsException("length=" + i + "; regionStart=" + i2 + "; regionLength=" + i3);
        }
    }
}
