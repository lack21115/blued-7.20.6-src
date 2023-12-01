package com.android.internal.util;

import com.sensetime.stmobile.STMobileHumanActionNative;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/FastMath.class */
public class FastMath {
    public static int round(float f) {
        return (int) ((STMobileHumanActionNative.ST_MOBILE_HAND_BLESS + (1.6777216E7f * f)) >> 24);
    }
}
