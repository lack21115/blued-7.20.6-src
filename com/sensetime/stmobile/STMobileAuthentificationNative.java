package com.sensetime.stmobile;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileAuthentificationNative.class */
public class STMobileAuthentificationNative {
    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public static native int checkActiveCode(Context context, String str, String str2, int i);

    public static native int checkActiveCodeFromBuffer(Context context, String str, int i, String str2, int i2);

    public static native String generateActiveCode(Context context, String str);

    public static native String generateActiveCodeFromBuffer(Context context, String str, int i);

    public static native String generateActiveCodeFromBufferOnline(Context context, String str, int i);

    public static native String generateActiveCodeOnline(Context context, String str);

    public static native int getExpiredTimeFromActivateCode(String str, String str2, long[] jArr);

    public static native int getExpiredTimeFromActivateCodeFromBuffer(String str, int i, String str2, int i2, long[] jArr);

    public static native int getLicenseExpiredTime(String str, String str2, int[] iArr, long[] jArr);

    public static native int getLicenseExpiredTimeFromBuffer(String str, int i, String str2, int i2, long[] jArr, long[] jArr2);
}
