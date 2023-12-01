package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/g.class */
public abstract class g {
    public static String a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(a.a(str, str2))) {
            z.c("hmsSdk", "getAndroidId(): to getConfigByType()");
            return c(context, str, str2);
        }
        return a.a(str, str2);
    }

    public static String b(Context context, String str, String str2) {
        if (!str2.equals("oper") && !str2.equals("maint") && !str2.equals("diffprivacy") && !str2.equals("preins")) {
            z.f("hmsSdk", "getChannel(): Invalid type: " + str2);
            return "";
        }
        return d(context, str, str2);
    }

    public static String c(Context context, String str, String str2) {
        if (a.b(str, str2)) {
            if (TextUtils.isEmpty(b.d())) {
                i.c().b().b(f.a(context));
            }
            return b.d();
        }
        return "";
    }

    public static String d(Context context, String str, String str2) {
        if (TextUtils.isEmpty(c.d(str, str2))) {
            l b = i.c().b();
            if (TextUtils.isEmpty(b.h())) {
                String b2 = f.b(context);
                String str3 = b2;
                if (!t0.a("channel", b2, 256)) {
                    str3 = "";
                }
                b.f(str3);
            }
            return b.h();
        }
        return c.d(str, str2);
    }
}
