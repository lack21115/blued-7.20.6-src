package com.tencent.beacon.base.util;

import android.os.Build;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/util/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f21303a;

    public static String a() {
        String str = f21303a;
        if (str != null) {
            return str;
        }
        try {
            f21303a = (String) Class.forName("android.app.ActivityThread").getDeclaredMethod(Build.VERSION.SDK_INT >= 18 ? "currentProcessName" : "currentPackageName", new Class[0]).invoke(null, new Object[0]);
            return "";
        } catch (Throwable th) {
            c.a(th);
            return "";
        }
    }
}
