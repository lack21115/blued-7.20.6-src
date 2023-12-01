package com.uc.crashsdk.a;

import android.util.Log;
import com.uc.crashsdk.JNIBridge;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/a/a.class */
public final class a {
    public static void a(String str) {
        if (com.uc.crashsdk.g.O()) {
            Log.d("crashsdk", str);
        }
    }

    public static void a(String str, String str2) {
        if (com.uc.crashsdk.g.O()) {
            Log.i(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (com.uc.crashsdk.g.O()) {
            if (th == null) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, th);
            }
        }
    }

    public static void b(String str) {
        if (com.uc.crashsdk.g.O()) {
            Log.w("crashsdk", str);
        }
    }

    public static void b(String str, String str2) {
        if (com.uc.crashsdk.b.d) {
            JNIBridge.nativeLog(4, str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (com.uc.crashsdk.b.d) {
            JNIBridge.nativeLog(5, str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (com.uc.crashsdk.b.d) {
            JNIBridge.nativeLog(6, str, str2);
        } else {
            Log.e(str, str2);
        }
    }
}
