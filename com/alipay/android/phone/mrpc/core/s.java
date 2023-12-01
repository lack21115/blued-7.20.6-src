package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/s.class */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f4537a;

    public static final boolean a(Context context) {
        Boolean bool = f4537a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0);
            f4537a = valueOf;
            return valueOf.booleanValue();
        } catch (Exception e) {
            return false;
        }
    }
}
