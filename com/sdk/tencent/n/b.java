package com.sdk.tencent.n;

import android.util.Log;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/n/b.class */
public class b {
    public static int a(String str, String str2, Boolean bool) {
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        if (bool.booleanValue()) {
            return Log.e(str, str3);
        }
        return -1;
    }

    public static Boolean a(String str) {
        return (str == null || str.length() == 0 || str.trim().length() == 0 || com.igexin.push.core.b.l.equals(str)) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static int b(String str, String str2, Boolean bool) {
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        if (bool.booleanValue()) {
            return Log.i(str, str3);
        }
        return -1;
    }

    public static Boolean b(String str) {
        return (str == null || str.length() == 0 || str.trim().length() == 0 || com.igexin.push.core.b.l.equals(str) || str.equals("")) ? Boolean.FALSE : Boolean.TRUE;
    }

    public static int c(String str, String str2, Boolean bool) {
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        if (bool.booleanValue()) {
            return Log.w(str, str3);
        }
        return -1;
    }
}
