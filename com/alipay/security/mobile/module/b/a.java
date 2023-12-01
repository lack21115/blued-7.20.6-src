package com.alipay.security.mobile.module.b;

import android.content.Context;
import com.kuaishou.weapon.p0.bp;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f4704a = new a();

    private a() {
    }

    public static a a() {
        return f4704a;
    }

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception e) {
            return bp.e;
        }
    }
}
