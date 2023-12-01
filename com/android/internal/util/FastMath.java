package com.android.internal.util;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/FastMath.class */
public class FastMath {
    public static int round(float f) {
        return (int) ((8388608 + (1.6777216E7f * f)) >> 24);
    }
}
