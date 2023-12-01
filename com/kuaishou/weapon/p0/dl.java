package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dl.class */
public final class dl {

    /* renamed from: a  reason: collision with root package name */
    private static a f23826a;

    /* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dl$a.class */
    public enum a {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    private dl() {
    }

    public static String a(Context context) {
        return b(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean b(Context context) {
        try {
            return c(context) == a.ARM64_V8A;
        } catch (Throwable th) {
            return false;
        }
    }

    private static a c(Context context) {
        a aVar;
        a aVar2 = f23826a;
        if (aVar2 != null) {
            return aVar2;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT < 23) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                        f23826a = ((Boolean) cls.getDeclaredMethod("is64Bit", new Class[0]).invoke(cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(cls, new Object[0]), new Object[0])).booleanValue() ? a.ARM64_V8A : a.ARMEABI_V7A;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        try {
                            f23826a = context.getApplicationInfo().nativeLibraryDir.contains("arm64") ? a.ARM64_V8A : a.UNKNOWN;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            aVar = a.UNKNOWN;
                        }
                    }
                }
                return f23826a;
            } else if (Process.is64Bit()) {
                aVar = a.ARM64_V8A;
            }
            f23826a = aVar;
            return f23826a;
        }
        aVar = a.ARMEABI_V7A;
        f23826a = aVar;
        return f23826a;
    }
}
