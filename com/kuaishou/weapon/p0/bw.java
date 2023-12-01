package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/bw.class */
public class bw {

    /* renamed from: a  reason: collision with root package name */
    private static String f23764a = c.b("Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n", 2);
    private static String b = c.b(b, 2);
    private static String b = c.b(b, 2);

    public static String a(Context context) {
        String str = TextUtils.isEmpty(d(context)) ? "0" : "1";
        String c2 = c(context);
        if (TextUtils.isEmpty(c2)) {
            return "0" + str;
        }
        String str2 = "1" + str;
        b(context, c2);
        return str2;
    }

    public static void a(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(context.getApplicationContext())) {
                Settings.System.putString(context.getContentResolver(), f23764a, str);
            }
        } catch (Exception e) {
        }
    }

    public static String b(Context context) {
        String c2 = c(context);
        String d = d(context);
        if (TextUtils.isEmpty(c2) || !TextUtils.equals(c2, d)) {
            if (!TextUtils.isEmpty(c2)) {
                b(context, c2);
                return c2;
            } else if (TextUtils.isEmpty(d)) {
                return "";
            } else {
                a(context, d);
                return d;
            }
        }
        return c2;
    }

    public static void b(Context context, String str) {
        de.a(context).d(str);
    }

    public static String c(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), f23764a);
        } catch (Exception e) {
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return de.a(context).e();
        } catch (Exception e) {
            return "";
        }
    }
}
