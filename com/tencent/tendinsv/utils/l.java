package com.tencent.tendinsv.utils;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/l.class */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f39104a = com.tencent.tendinsv.b.D;

    private static String a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        if (objArr != null) {
            try {
                int length = objArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    sb.append(objArr[i2]);
                    sb.append("**");
                    i = i2 + 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static void a(String str, Object... objArr) {
        if (f39104a) {
            Log.d(str, a(objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        if (com.tencent.tendinsv.b.E) {
            Log.v(str, a(objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (f39104a) {
            Log.i(str, a(objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        if (f39104a) {
            Log.w(str, a(objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        if (f39104a) {
            Log.e(str, a(objArr));
        }
    }
}
