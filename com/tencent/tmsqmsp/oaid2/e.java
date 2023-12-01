package com.tencent.tmsqmsp.oaid2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static Context f39624a;

    public static Context a() {
        Context context;
        synchronized (e.class) {
            try {
                if (f39624a == null) {
                    f39624a = b();
                }
                context = f39624a;
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
