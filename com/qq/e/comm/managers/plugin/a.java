package com.qq.e.comm.managers.plugin;

import java.lang.reflect.Method;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/plugin/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Method f27918a;
    private static boolean b = false;

    public static void a(Throwable th, String str) {
        try {
            Exception exc = new Exception("插件错误：" + str, th);
            if (b) {
                return;
            }
            if (f27918a == null) {
                Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
                f27918a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            f27918a.invoke(null, exc);
        } catch (Throwable th2) {
            b = true;
        }
    }
}
