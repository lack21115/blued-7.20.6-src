package com.igexin.push.f;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.util.Base64;
import com.getui.gtc.base.GtcProvider;
import java.lang.reflect.Method;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/k.class */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static int f23658a = Integer.MIN_VALUE;
    private static String b = "GT_PM";

    /* renamed from: c  reason: collision with root package name */
    private static Object f23659c;

    private static int a() {
        int i = f23658a;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        if (GtcProvider.context() == null || Build.VERSION.SDK_INT < 17) {
            return 0;
        }
        try {
            Class<?> cls = Class.forName(new String(Base64.decode("YW5kcm9pZC5vcy5Vc2VySGFuZGxl", 0)));
            Method declaredMethod = cls.getDeclaredMethod(new String(Base64.decode("Z2V0VXNlcklk", 0)), Integer.TYPE);
            declaredMethod.setAccessible(true);
            int intValue = ((Integer) declaredMethod.invoke(cls, Integer.valueOf(Process.myUid()))).intValue();
            f23658a = intValue;
            return intValue;
        } catch (Throwable th) {
            th.getMessage();
            return 0;
        }
    }

    public static PackageInfo a(String str) throws PackageManager.NameNotFoundException {
        PackageInfo a2 = a(str, a());
        if (a2 != null) {
            return a2;
        }
        throw new PackageManager.NameNotFoundException(str + " not found");
    }

    private static PackageInfo a(String str, int i) {
        try {
            if (f23659c == null) {
                f23659c = Class.forName(new String(Base64.decode("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=", 0))).getMethod(new String(Base64.decode("Z2V0UGFja2FnZU1hbmFnZXI=", 0)), new Class[0]).invoke(null, new Object[0]);
            }
            String str2 = new String(Base64.decode("Z2V0UGFja2FnZUluZm8=", 0));
            return (PackageInfo) (Build.VERSION.SDK_INT >= 16 ? f23659c.getClass().getMethod(str2, String.class, Integer.TYPE, Integer.TYPE).invoke(f23659c, str, 0, Integer.valueOf(i)) : f23659c.getClass().getMethod(str2, String.class, Integer.TYPE).invoke(f23659c, str, 0));
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }
}
