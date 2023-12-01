package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/av.class */
public class av {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f41262a = false;

    private static void a(Class<?> cls, Context context) {
        if (f41262a) {
            return;
        }
        try {
            f41262a = true;
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("mdid:load lib error ".concat(String.valueOf(th)));
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
            com.xiaomi.channel.commonutils.logger.b.m11394a("mdid:check error ".concat(String.valueOf(th)));
            return false;
        }
    }
}
