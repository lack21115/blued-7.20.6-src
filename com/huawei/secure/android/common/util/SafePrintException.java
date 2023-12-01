package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/SafePrintException.class */
public abstract class SafePrintException {
    private static boolean a(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                return false;
            }
            if (str.contains(new String[]{"java.io.FileNotFoundException", "java.util.jar.JarException", "java.util.MissingResourceException", "java.security.acl.NotOwnerException", "java.util.ConcurrentModificationException", "javax.naming.InsufficientResourcesException", "java.net.BindException", "java.lang.OutOfMemoryError", "java.lang.StackOverflowError", "java.sql.SQLException"}[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static String getStackTrace(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        sb.append("Exception: ");
        sb.append(th.getClass().getName());
        sb.append('\n');
        if (!a(th.getClass().getCanonicalName())) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    sb.append(stackTrace[i2].toString());
                    sb.append('\n');
                    i = i2 + 1;
                }
            } else {
                sb.append("Stack trace is NULL!");
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static void print(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        Log.w(str, getStackTrace(str2, th));
    }
}
