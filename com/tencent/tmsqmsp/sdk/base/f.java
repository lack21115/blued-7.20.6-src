package com.tencent.tmsqmsp.sdk.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/base/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static Context f39702a;

    public static Context a() {
        Context context;
        synchronized (f.class) {
            try {
                if (f39702a == null) {
                    f39702a = b();
                }
                context = f39702a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return context;
    }

    public static String a(Context context) {
        String packageName;
        if (context == null) {
            return "";
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null && !TextUtils.isEmpty(applicationInfo.packageName)) {
                packageName = applicationInfo.packageName;
                return packageName;
            }
            packageName = a().getPackageName();
            return packageName;
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
