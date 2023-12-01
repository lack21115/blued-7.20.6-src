package com.kwad.sdk.utils;

import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ao.class */
public final class ao {
    private static void a(RuntimeException runtimeException) {
        com.kwad.sdk.core.d.b.printStackTrace(runtimeException);
    }

    public static String ah(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            a(new NullPointerException("Argument cannot be null " + str2));
        }
        return str;
    }

    public static void checkArgument(boolean z, Object obj) {
        if (z) {
            return;
        }
        a(new IllegalArgumentException("Expression cannot be false " + obj));
    }

    public static <T> T checkNotNull(T t) {
        return (T) f(t, "");
    }

    public static void e(Object... objArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return;
            }
            checkNotNull(objArr[i2]);
            i = i2 + 1;
        }
    }

    public static String eK(String str) {
        return ah(str, "");
    }

    public static <T> T f(T t, String str) {
        if (t == null) {
            a(new NullPointerException("Argument cannot be null " + str));
        }
        return t;
    }
}
