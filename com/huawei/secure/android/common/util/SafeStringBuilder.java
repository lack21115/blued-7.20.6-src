package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/SafeStringBuilder.class */
public class SafeStringBuilder {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9542a = "SafeStringBuilder";
    private static final String b = "";

    public static String substring(StringBuilder sb, int i) {
        if (TextUtils.isEmpty(sb) || sb.length() < i || i < 0) {
            return "";
        }
        try {
            return sb.substring(i);
        } catch (Exception e) {
            String str = f9542a;
            Log.e(str, "substring exception: " + e.getMessage());
            return "";
        }
    }

    public static String substring(StringBuilder sb, int i, int i2) {
        if (TextUtils.isEmpty(sb) || i < 0 || i2 > sb.length() || i2 < i) {
            return "";
        }
        try {
            return sb.substring(i, i2);
        } catch (Exception e) {
            String str = f9542a;
            Log.e(str, "substring: " + e.getMessage());
            return "";
        }
    }
}
