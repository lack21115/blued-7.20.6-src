package com.xiaomi.push;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/av.class */
class av {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f27571a = false;

    private static void a(Class<?> cls, Context context) {
        if (f27571a) {
            return;
        }
        try {
            f27571a = true;
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("mdid:load lib error ".concat(String.valueOf(th)));
        }
    }

    public static boolean a(Context context) {
        try {
            Class<?> a2 = r.a(context, "com.bun.miitmdid.core.JLibrary");
            if (a2 != null) {
                a(a2, context);
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("mdid:check error ".concat(String.valueOf(th)));
            return false;
        }
    }
}
