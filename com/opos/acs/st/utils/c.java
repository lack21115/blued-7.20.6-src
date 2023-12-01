package com.opos.acs.st.utils;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/utils/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10773a = false;
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f10774c = false;

    public static String a(Context context) {
        if (TextUtils.isEmpty(b)) {
            b = com.opos.cmn.biz.a.d.a(context);
        }
        return b;
    }

    public static void a() {
        f10774c = true;
    }

    public static void a(Context context, String str) {
        com.opos.cmn.biz.a.d.a(context, str);
    }

    public static void a(boolean z) {
        f10773a = z;
    }

    public static String b(Context context) {
        String str = null;
        if (TextUtils.isEmpty(null)) {
            str = com.opos.cmn.biz.a.b.a(context);
        }
        return str;
    }

    public static void b(Context context, String str) {
        com.opos.cmn.biz.a.b.a(context, str);
    }

    public static boolean b() {
        return f10774c;
    }

    public static void c(Context context) {
        if (context != null) {
            try {
                com.opos.cmn.g.a.b.d(context);
                boolean z = true;
                if (context != null) {
                    z = true;
                    if ("CN".equalsIgnoreCase(a(context))) {
                        z = false;
                    }
                }
                d.a("InitUtil", "isOverseas=".concat(String.valueOf(z)));
                if (z) {
                    com.opos.cmn.g.a.b.f(context);
                }
            } catch (Exception e) {
                d.c("InitUtil", "", e);
            }
        }
    }
}
