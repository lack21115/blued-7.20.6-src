package com.kuaishou.weapon.p0;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/br.class */
public final class br {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23759a = "weapon.set";
    private static String e;
    private static String b = c.b("Y29tLmt3YWkud2VhcG9u", 2);

    /* renamed from: c  reason: collision with root package name */
    private static String f23760c = c.b(f23760c, 2);

    /* renamed from: c  reason: collision with root package name */
    private static String f23760c = c.b(f23760c, 2);
    private static String d = c.b(d, 2);
    private static String d = c.b(d, 2);

    private br() {
    }

    public static String a(Context context) {
        synchronized (br.class) {
            try {
                if (!TextUtils.isEmpty(e)) {
                    return e;
                }
                String c2 = c(context);
                e = c2;
                return c2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Exception e2) {
            return "";
        }
    }

    private static void b(Context context, String str) {
        c(context, str);
        d(context, str);
    }

    public static boolean b(Context context) {
        return Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(context.getApplicationContext());
    }

    private static String c(Context context) {
        String e2 = e(context);
        if (TextUtils.isEmpty(e2)) {
            String d2 = d(context);
            if (!TextUtils.isEmpty(d2)) {
                b(context, d2);
            }
            return d2;
        }
        return e2;
    }

    private static void c(Context context, String str) {
        try {
            if (b(context)) {
                ContentResolver contentResolver = context.getContentResolver();
                Settings.System.putString(contentResolver, f23760c, str);
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                Settings.System.putString(contentResolver, f23759a, sb.toString());
            }
        } catch (Exception e2) {
        }
    }

    private static String d(Context context) {
        String str;
        try {
            h a2 = h.a(context, "re_po_rt");
            boolean e2 = a2.e("a1_p_s_p_s");
            boolean e3 = a2.e("a1_p_s_p_s_c_b");
            String f = (e2 || e3) ? bg.f(context) : "";
            if (TextUtils.isEmpty(f)) {
                f = UUID.randomUUID().toString();
            }
            String str2 = f + b;
            String c2 = (e2 || e3) ? bg.c(context) : "";
            if (!TextUtils.isEmpty(c2)) {
                str = c2;
                if (c2.startsWith("RISK")) {
                }
                String stringBuffer = new StringBuffer(str).reverse().toString();
                String a3 = f.a(str2);
                return new bm(context).a(a3.toUpperCase() + "|" + stringBuffer.toUpperCase(), bh.u);
            }
            str = "0";
            String stringBuffer2 = new StringBuffer(str).reverse().toString();
            String a32 = f.a(str2);
            return new bm(context).a(a32.toUpperCase() + "|" + stringBuffer2.toUpperCase(), bh.u);
        } catch (Throwable th) {
            return "";
        }
    }

    private static void d(Context context, String str) {
        de.a(context).c(str);
    }

    private static String e(Context context) {
        String a2 = a(context, f23760c);
        String f = f(context);
        if (TextUtils.isEmpty(a2) || !TextUtils.equals(a2, f)) {
            if (!TextUtils.isEmpty(a2)) {
                d(context, a2);
                return a2;
            } else if (TextUtils.isEmpty(f)) {
                return "";
            } else {
                c(context, f);
                return f;
            }
        }
        return a2;
    }

    private static String f(Context context) {
        try {
            return de.a(context).d();
        } catch (Exception e2) {
            return "";
        }
    }
}
