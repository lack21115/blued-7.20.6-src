package com.amap.api.col.p0003sl;

import android.content.Context;
import android.util.Log;

/* renamed from: com.amap.api.col.3sl.dc  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/dc.class */
public final class dc {
    static String a;

    static {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 80) {
                a = sb.toString();
                return;
            } else {
                sb.append("=");
                i = i2 + 1;
            }
        }
    }

    public static void a() {
        c(a);
        c("当前使用的自定义地图样式文件和目前版本不匹配，请到官网(lbs.amap.com)更新新版样式文件");
        c(a);
    }

    public static void a(Context context, String str) {
        c(a);
        if (context != null) {
            b("key:" + ho.f(context));
        }
        c(str);
        c(a);
    }

    public static void a(String str) {
        c(a);
        c(str);
        c(a);
    }

    private static void b(String str) {
        if (str.length() >= 78) {
            c("|" + str.substring(0, 78) + "|");
            b(str.substring(78));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append(str);
        for (int i = 0; i < 78 - str.length(); i++) {
            sb.append(" ");
        }
        sb.append("|");
        c(sb.toString());
    }

    private static void c(String str) {
        Log.i("authErrLog", str);
    }
}
