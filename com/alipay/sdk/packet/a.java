package com.alipay.sdk.packet;

import android.text.TextUtils;
import com.alipay.sdk.util.i;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/packet/a.class */
public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(com.alipay.sdk.sys.a.b);
        if (split.length == 0) {
            return "";
        }
        int length = split.length;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (i < length) {
            String str6 = split[i];
            String str7 = str2;
            if (TextUtils.isEmpty(str2)) {
                str7 = b(str6);
            }
            String str8 = str3;
            if (TextUtils.isEmpty(str3)) {
                str8 = c(str6);
            }
            String str9 = str4;
            if (TextUtils.isEmpty(str4)) {
                str9 = d(str6);
            }
            String str10 = str5;
            if (TextUtils.isEmpty(str5)) {
                str10 = f(str6);
            }
            i++;
            str2 = str7;
            str3 = str8;
            str4 = str9;
            str5 = str10;
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            sb.append("biz_type=" + str2 + i.b);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append("biz_no=" + str3 + i.b);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("trade_no=" + str4 + i.b);
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append("app_userid=" + str5 + i.b);
        }
        String sb2 = sb.toString();
        String str11 = sb2;
        if (sb2.endsWith(i.b)) {
            str11 = sb2.substring(0, sb2.length() - 1);
        }
        return str11;
    }

    private static String b(String str) {
        if (str.contains("biz_type")) {
            return e(str);
        }
        return null;
    }

    private static String c(String str) {
        if (str.contains("biz_no")) {
            return e(str);
        }
        return null;
    }

    private static String d(String str) {
        if (!str.contains(com.alipay.sdk.app.statistic.c.ap) || str.startsWith(com.alipay.sdk.app.statistic.c.ao)) {
            return null;
        }
        return e(str);
    }

    private static String e(String str) {
        String str2;
        String[] split = str.split("=");
        if (split.length > 1) {
            String str3 = split[1];
            str2 = str3;
            if (str3.contains("\"")) {
                return str3.replaceAll("\"", "");
            }
        } else {
            str2 = null;
        }
        return str2;
    }

    private static String f(String str) {
        if (str.contains("app_userid")) {
            return e(str);
        }
        return null;
    }
}
