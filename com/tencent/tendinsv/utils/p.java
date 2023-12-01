package com.tencent.tendinsv.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/p.class */
public class p {
    public static String a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    public static String a(int i) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
            String trim = bufferedReader.readLine().replace((char) 0, ' ').trim();
            bufferedReader.close();
            return trim;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String a(Context context) {
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            String b = b();
            return !TextUtils.isEmpty(b) ? b : b(context);
        }
        return a2;
    }

    public static String b() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        return a(Process.myPid());
    }

    public static boolean c(Context context) {
        return context.getPackageName().equals(a(context));
    }
}
