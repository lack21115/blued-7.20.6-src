package com.umeng.analytics.pro;

import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bg.class */
public class bg {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26962a = "OpenId";
    private static boolean b = false;

    private static String a(Object obj, Object obj2) {
        Object obj3 = obj;
        if (obj == null) {
            obj3 = "";
        }
        Object obj4 = obj2;
        if (obj2 == null) {
            obj4 = "";
        }
        return String.format("%s:%s", obj3, obj4);
    }

    public static void a(String str, Object... objArr) {
        if (b) {
            Log.d(f26962a, e(str, objArr));
        }
    }

    public static void a(boolean z) {
        Log.d(f26962a, "setDebug:" + z);
        b = z;
    }

    public static void b(String str, Object... objArr) {
        if (b) {
            Log.i(f26962a, e(str, objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (b) {
            Log.w(f26962a, e(str, objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        if (b) {
            Log.e(f26962a, e(str, objArr));
        }
    }

    private static String e(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str2 = str;
        if (str == null) {
            str2 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        int i = 0;
        sb.append(String.format("[%s] ", str2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(a(objArr[i], objArr[i2]));
                if (i2 < length - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }
}
