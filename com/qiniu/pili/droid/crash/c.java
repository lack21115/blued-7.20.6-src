package com.qiniu.pili.droid.crash;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f13786a = false;

    public static void a(Context context) {
        synchronized (c.class) {
            try {
                if (f13786a) {
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                if (k.a(applicationContext)) {
                    f.a().a(applicationContext);
                    NativeCrashHandler.a().a(applicationContext);
                    h.a().a(applicationContext);
                    f13786a = true;
                }
            } finally {
            }
        }
    }
}
