package com.tencent.qmsp.sdk.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/base/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static Context f38544a;

    public static Context a() {
        Context context;
        synchronized (f.class) {
            try {
                if (f38544a == null) {
                    f38544a = b();
                }
                context = f38544a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return context;
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null && !TextUtils.isEmpty(applicationInfo.packageName)) {
                return applicationInfo.packageName;
            }
            return a().getPackageName();
        } catch (Exception e) {
            return "";
        }
    }

    public static Context b() {
        try {
            return (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
