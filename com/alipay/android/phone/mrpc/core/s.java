package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/s.class */
public final class s {
    private static Boolean a;

    public static final boolean a(Context context) {
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0);
            a = valueOf;
            return valueOf.booleanValue();
        } catch (Exception e) {
            return false;
        }
    }
}
