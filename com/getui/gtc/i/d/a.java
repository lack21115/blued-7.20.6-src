package com.getui.gtc.i.d;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.util.Base64;
import java.lang.reflect.Method;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/i/d/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f22035a = Integer.MIN_VALUE;
    private static Object b;

    private static int a() {
        int i = f22035a;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                Class<?> cls = Class.forName(new String(Base64.decode("YW5kcm9pZC5vcy5Vc2VySGFuZGxl", 0)));
                Method declaredMethod = cls.getDeclaredMethod(new String(Base64.decode("Z2V0VXNlcklk", 0)), Integer.TYPE);
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(cls, Integer.valueOf(Process.myUid()))).intValue();
                f22035a = intValue;
                return intValue;
            } catch (Throwable th) {
                com.getui.gtc.i.c.a.a(th);
                return 0;
            }
        }
        return 0;
    }

    public static PackageInfo a(String str) throws PackageManager.NameNotFoundException {
        PackageInfo a2 = a(str, a());
        if (a2 != null) {
            return a2;
        }
        throw new PackageManager.NameNotFoundException("packageName not found");
    }

    private static PackageInfo a(String str, int i) {
        try {
            if (b == null) {
                b = Class.forName(new String(Base64.decode("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=", 0))).getMethod(new String(Base64.decode("Z2V0UGFja2FnZU1hbmFnZXI=", 0)), new Class[0]).invoke(null, new Object[0]);
            }
            String str2 = new String(Base64.decode("Z2V0UGFja2FnZUluZm8=", 0));
            return (PackageInfo) (Build.VERSION.SDK_INT >= 16 ? b.getClass().getMethod(str2, String.class, Integer.TYPE, Integer.TYPE).invoke(b, str, 0, Integer.valueOf(i)) : b.getClass().getMethod(str2, String.class, Integer.TYPE).invoke(b, str, 0));
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.a(th);
            return null;
        }
    }
}
