package com.opos.cmn.biz.ststrategy.c;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.envdev.api.EnvDevConfig;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/c/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24706a = f.class.getSimpleName();

    public static String a(Context context) {
        String str = "";
        String str2 = str;
        if (context != null) {
            try {
                str = EnvDevConfig.getSTConfigUrl(context);
            } catch (Throwable th) {
            }
            if (TextUtils.isEmpty(str)) {
                return com.opos.cmn.biz.d.b.a.a(context);
            }
            String a2 = com.opos.cmn.biz.d.b.a.a(context);
            String str3 = f24706a;
            com.opos.cmn.an.f.a.b(str3, "getSTConfigUrl pub=" + a2);
            str2 = str;
        }
        return str2;
    }

    public static boolean a(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean b(Context context) {
        boolean a2 = com.opos.cmn.biz.d.b.a.a();
        String str = f24706a;
        com.opos.cmn.an.f.a.b(str, "isOverseas=" + a2);
        return a2;
    }

    public static boolean c(Context context) {
        boolean z;
        if (context != null) {
            try {
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c(f24706a, "", e);
            }
            if (com.opos.cmn.biz.a.d.a(context).equalsIgnoreCase(d.b(context))) {
                z = true;
                com.opos.cmn.an.f.a.b(f24706a, "isLastRegion=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b(f24706a, "isLastRegion=" + z);
        return z;
    }
}
