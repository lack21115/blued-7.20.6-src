package com.huawei.secure.android.common.util;

import android.util.Log;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/SafeStringBuffer.class */
public class SafeStringBuffer {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9541a = "SafeStringBuffer";
    private static final String b = "";

    public static String substring(StringBuffer stringBuffer, int i) {
        if (stringBuffer == null || stringBuffer.length() < i || i < 0) {
            return "";
        }
        try {
            return stringBuffer.substring(i);
        } catch (Exception e) {
            String str = f9541a;
            Log.e(str, "substring exception: " + e.getMessage());
            return "";
        }
    }

    public static String substring(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null || i < 0 || i2 > stringBuffer.length() || i2 < i) {
            return "";
        }
        try {
            return stringBuffer.substring(i, i2);
        } catch (Exception e) {
            String str = f9541a;
            Log.e(str, "substring: " + e.getMessage());
            return "";
        }
    }
}
