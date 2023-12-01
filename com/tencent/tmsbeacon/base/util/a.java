package com.tencent.tmsbeacon.base.util;

import android.os.Build;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/util/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f25834a;

    public static String a() {
        String str = f25834a;
        if (str != null) {
            return str;
        }
        try {
            f25834a = (String) Class.forName("android.app.ActivityThread").getDeclaredMethod(Build.VERSION.SDK_INT >= 18 ? "currentProcessName" : "currentPackageName", new Class[0]).invoke(null, new Object[0]);
            return "";
        } catch (Throwable th) {
            c.a(th);
            return "";
        }
    }
}
