package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/util/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Context f23128a;

    public static Context a() {
        return f23128a;
    }

    public static void a(Context context) {
        if (context == null || f23128a != null) {
            return;
        }
        f23128a = context.getApplicationContext();
    }
}
