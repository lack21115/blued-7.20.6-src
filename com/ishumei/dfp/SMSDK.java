package com.ishumei.dfp;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/dfp/SMSDK.class */
public class SMSDK {
    static {
        try {
            System.loadLibrary("smsdk");
        } catch (Throwable th) {
        }
    }

    public static String v1(Context context, String str, String str2, String str3, String str4, String str5) {
        return new SMSDK().w1(context, str, str2, str3, str4, str5);
    }

    public static String v3(Context context, String str, String str2, String str3, String str4) {
        try {
            return new SMSDK().w3(context, str, str2, str3, str4);
        } catch (Throwable th) {
            return "";
        }
    }

    private native String w3(Context context, String str, String str2, String str3, String str4);

    private native String x6(String str, String str2);

    public static String xx6(String str, String str2) {
        try {
            return new SMSDK().x6(str, str2);
        } catch (Throwable th) {
            return "";
        }
    }

    public native String w1(Context context, String str, String str2, String str3, String str4, String str5);
}
