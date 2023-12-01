package com.loopj.android.http;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/AssertUtils.class */
class AssertUtils {
    private AssertUtils() {
    }

    public static void asserts(boolean z, String str) {
        if (!z) {
            throw new AssertionError(str);
        }
    }
}
