package com.bytedance.sdk.openadsdk.api;

import android.util.Log;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/mb.class */
public class mb {
    private static boolean mb = false;
    private static int ox = 4;

    public static void b(String str, String str2) {
        if (mb && str2 != null && ox <= 4) {
            Log.i(str, str2);
        }
    }

    public static void h(String str, String str2) {
        if (mb && str2 != null && ox <= 6) {
            Log.e(str, str2);
        }
    }

    public static void hj(String str, String str2) {
        if (mb && str2 != null && ox <= 5) {
            Log.w(str, str2);
        }
    }

    private static String mb(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            Object obj = objArr[i2];
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
            i = i2 + 1;
        }
    }

    public static void mb() {
        mb = true;
        mb(3);
    }

    public static void mb(int i) {
        ox = i;
    }

    public static void mb(String str) {
        if (mb) {
            hj("TTLogger", str);
        }
    }

    public static void mb(String str, String str2) {
        if (mb && str2 != null && ox <= 2) {
            Log.v(str, str2);
        }
    }

    public static void mb(String str, String str2, Throwable th) {
        if (mb) {
            if (!(str2 == null && th == null) && ox <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    public static void mb(String str, Object... objArr) {
        if (mb && objArr != null && ox <= 5) {
            Log.v(str, mb(objArr));
        }
    }

    public static void ox(String str, String str2) {
        if (mb && str2 != null && ox <= 3) {
            Log.d(str, str2);
        }
    }

    public static void ox(String str, String str2, Throwable th) {
        if (mb) {
            if (!(str2 == null && th == null) && ox <= 6) {
                Log.e(str, str2, th);
            }
        }
    }
}
