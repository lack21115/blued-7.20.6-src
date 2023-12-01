package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/i.class */
public class i {
    public static final String a = "pref_trade_token";
    public static final String b = ";";
    public static final String c = "result={";
    public static final String d = "}";
    public static final String e = "trade_token=\"";
    public static final String f = "\"";
    public static final String g = "trade_token=";

    public static String a(com.alipay.sdk.sys.a aVar, Context context) {
        String b2 = j.b(aVar, context, a, "");
        c.a(com.alipay.sdk.cons.a.x, "get trade token: " + b2);
        return b2;
    }

    public static String a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(b);
        int i = 0;
        while (i < split.length) {
            String str3 = str2;
            if (split[i].startsWith(c)) {
                str3 = str2;
                if (split[i].endsWith(d)) {
                    String[] split2 = split[i].substring(8, split[i].length() - 1).split(com.alipay.sdk.sys.a.b);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        str3 = str2;
                        if (i3 < split2.length) {
                            if (split2[i3].startsWith(e) && split2[i3].endsWith("\"")) {
                                str3 = split2[i3].substring(13, split2[i3].length() - 1);
                                break;
                            } else if (split2[i3].startsWith(g)) {
                                str3 = split2[i3].substring(12);
                                break;
                            } else {
                                i2 = i3 + 1;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            i++;
            str2 = str3;
        }
        return str2;
    }

    public static void a(com.alipay.sdk.sys.a aVar, Context context, String str) {
        try {
            String a2 = a(str);
            c.a(com.alipay.sdk.cons.a.x, "trade token: " + a2);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            j.a(aVar, context, a, a2);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.B, th);
            c.a(th);
        }
    }
}
