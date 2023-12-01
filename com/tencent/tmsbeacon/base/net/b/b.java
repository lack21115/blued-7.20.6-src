package com.tencent.tmsbeacon.base.net.b;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/b/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f25810a = "https://otheve.beacon.qq.com/analytics/v2_upload";
    public static String b = "https://othstr.beacon.qq.com/analytics/v2_upload";

    /* renamed from: c  reason: collision with root package name */
    public static String f25811c = "oth.eve.mdt.qq.com";
    public static String d = "oth.str.mdt.qq.com";
    private static boolean e = false;

    public static String a(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        String str2 = str.contains("https") ? "https://" : "http://";
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return str;
        }
        String substring = str.substring(indexOf + str2.length(), str.indexOf("/", str2.length()));
        int indexOf2 = substring.indexOf(":");
        String str3 = substring;
        if (indexOf2 != -1) {
            str3 = substring.substring(0, indexOf2);
        }
        return str3;
    }

    public static String a(boolean z) {
        return z ? f25811c : f25810a;
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            d = str;
            b = b.replace("othstr.beacon.qq.com", str);
            e = true;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        f25811c = str2;
        f25810a = f25810a.replace("otheve.beacon.qq.com", str2);
        e = true;
    }

    public static String b(boolean z) {
        return z ? d : b;
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str) || e) {
            return;
        }
        f25811c = str;
    }

    public static void b(String str, String str2) {
        Pattern compile = Pattern.compile("((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}");
        Matcher matcher = compile.matcher(str);
        Matcher matcher2 = compile.matcher(str2);
        if (!matcher.matches() || !matcher2.matches()) {
            com.tencent.tmsbeacon.base.util.e.a("[event url] set report ip is not valid IP address!");
            return;
        }
        d = str;
        b = b.replace("othstr.beacon.qq.com", str);
        f25811c = str2;
        String replace = f25810a.replace("otheve.beacon.qq.com", str2);
        f25810a = replace;
        com.tencent.tmsbeacon.base.util.c.a("[event url] ip modified by api, socketStrategyHost: %s, httpsStrategyUrl: %s, socketLogHost: %s ,httpsLogUrl: %s", d, b, f25811c, replace);
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str) || e) {
            return;
        }
        f25810a = str;
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str) || e) {
            return;
        }
        d = str;
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str) || e) {
            return;
        }
        b = str;
    }
}
