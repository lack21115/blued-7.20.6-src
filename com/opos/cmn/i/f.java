package com.opos.cmn.i;

import android.content.Context;
import android.text.TextUtils;
import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f11288a = "getCryptByKey";
    private static String b;

    public static final String a() {
        return UUID.randomUUID().toString();
    }

    public static final String a(Context context) {
        if (TextUtils.isEmpty(b)) {
            try {
                String c2 = c();
                String str = c2;
                if (TextUtils.isEmpty(c2)) {
                    str = d();
                }
                String str2 = str;
                if (TextUtils.isEmpty(str)) {
                    str2 = b();
                }
                if (TextUtils.isEmpty(str2)) {
                    return "";
                }
                b = str2;
                return str2;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("", "", e);
                return "";
            }
        }
        return b;
    }

    private static final String b() {
        String a2 = l.a("sys.serialnumber");
        String str = a2;
        if (TextUtils.isEmpty(a2)) {
            str = l.a("ril.serialnumber");
        }
        return str;
    }

    private static final String c() {
        return l.a("gsm.serial");
    }

    private static final String d() {
        return l.a("vendor.gsm.serial");
    }
}
