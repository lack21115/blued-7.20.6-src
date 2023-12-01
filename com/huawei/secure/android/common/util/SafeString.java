package com.huawei.secure.android.common.util;

import android.util.Log;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/SafeString.class */
public class SafeString {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23148a = "SafeString";
    private static final String b = "";

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (str != null && charSequence != null) {
            if (charSequence2 == null) {
                return str;
            }
            try {
                return str.replace(charSequence, charSequence2);
            } catch (Exception e) {
                String str2 = f23148a;
                Log.e(str2, "replace: " + e.getMessage());
            }
        }
        return str;
    }

    public static String substring(String str, int i) {
        if (str == null || str.length() < i || i < 0) {
            return "";
        }
        try {
            return str.substring(i);
        } catch (Exception e) {
            String str2 = f23148a;
            Log.e(str2, "substring exception: " + e.getMessage());
            return "";
        }
    }

    public static String substring(String str, int i, int i2) {
        if (str == null || i < 0 || i2 > str.length() || i2 < i) {
            return "";
        }
        try {
            return str.substring(i, i2);
        } catch (Exception e) {
            String str2 = f23148a;
            Log.e(str2, "substring: " + e.getMessage());
            return "";
        }
    }
}
