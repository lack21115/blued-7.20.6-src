package com.oplus.instant.router.g;

import android.util.Log;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/g/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f10610a;

    public static void a() {
        f10610a = true;
    }

    public static void a(String str, String str2) {
        if (f10610a) {
            Log.d(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        String str3;
        String message;
        StringBuilder sb;
        if (th != null) {
            if (f10610a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append("##Throwable##");
                String stackTraceString = Log.getStackTraceString(th);
                sb = sb2;
                message = stackTraceString;
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                message = th.getMessage();
                sb = sb3;
            }
            sb.append(message);
            Log.d(str, sb.toString());
            str3 = null;
        } else {
            str3 = "throwable is null";
        }
        c(str, str2 + str3);
    }

    public static void a(String str, Throwable th) {
        a(str, "", th);
    }

    public static void b(String str, String str2) {
        if (f10610a) {
            Log.i(str, str2);
        }
    }

    public static void c(String str, String str2) {
        Log.e(str, str2);
    }
}
