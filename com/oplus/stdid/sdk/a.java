package com.oplus.stdid.sdk;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import s_a.s_a.s_a.a.f;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/stdid/sdk/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10745a;
    public static boolean b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f10746c;

    public static Context a(Context context) {
        Context context2 = context;
        if (context != null) {
            context2 = context;
            if (context.getApplicationContext() != null) {
                context2 = context.getApplicationContext();
            }
        }
        return context2;
    }

    public static boolean a() {
        if (f10746c) {
            if (!f10745a) {
                Log.e("StdIDHelper", "1001");
            }
            return b;
        }
        if (!s_a.s_a.s_a.a.d.a) {
            Log.e("IDHelper", "1001");
        }
        return s_a.s_a.s_a.a.d.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.stdid.sdk.a.b(android.content.Context):void");
    }

    public static boolean b() {
        String str;
        if (!f10745a) {
            str = "1001";
        } else if (!b) {
            str = "1002";
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            return true;
        } else {
            str = "1003";
        }
        Log.e("StdIDHelper", str);
        return false;
    }

    public static String c(Context context) {
        if (f10746c) {
            b.a("2001");
            return !b() ? "" : c.a().a(a(context), "GUID");
        }
        f.a("2001");
        return !s_a.s_a.s_a.a.d.a() ? "" : s_a.s_a.s_a.a.b.a().a(s_a.s_a.s_a.a.d.a(context), "GUID");
    }

    public static boolean d(Context context) {
        if (f10746c) {
            b.a("2002");
            return false;
        }
        f.a("2002");
        if (s_a.s_a.s_a.a.d.a()) {
            return "TRUE".equalsIgnoreCase(s_a.s_a.s_a.a.b.a().a(s_a.s_a.s_a.a.d.a(context), "OUID_STATUS"));
        }
        return false;
    }

    public static String e(Context context) {
        if (f10746c) {
            b.a("2003");
            return null;
        }
        f.a("2003");
        return !s_a.s_a.s_a.a.d.a() ? "" : s_a.s_a.s_a.a.b.a().a(s_a.s_a.s_a.a.d.a(context), "OUID");
    }

    public static String f(Context context) {
        if (f10746c) {
            b.a("2004");
            return !b() ? "" : c.a().a(a(context), "DUID");
        }
        f.a("2004");
        return !s_a.s_a.s_a.a.d.a() ? "" : s_a.s_a.s_a.a.b.a().a(s_a.s_a.s_a.a.d.a(context), "DUID");
    }
}
