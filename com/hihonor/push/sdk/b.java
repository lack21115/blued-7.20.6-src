package com.hihonor.push.sdk;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/b.class */
public class b {
    public static void a(String str) {
        String str2;
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            int i2 = i;
            if (i2 >= stackTrace.length) {
                str2 = "";
                break;
            } else if (!stackTrace[i2].getClass().equals(b.class)) {
                String className = stackTrace[i2].getClassName();
                str2 = className.substring(className.lastIndexOf(46) + 1);
                break;
            } else {
                i = i2 + 1;
            }
        }
        a("HonorPush_".concat(String.valueOf(str2)), str, null);
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2.length() <= 4000) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str2.length()) {
                return;
            }
            int i3 = i2 + 4000;
            if (i3 < str2.length()) {
                str2.substring(i2, i3);
            } else {
                str2.substring(i2);
            }
            i = i3;
        }
    }
}
