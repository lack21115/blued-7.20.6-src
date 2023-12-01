package com.opos.cmn.an.f.a;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f24529a = false;

    public static void a(Context context, boolean z) {
        synchronized (f.class) {
            try {
                f24529a = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean a(Context context) {
        boolean z;
        synchronized (f.class) {
            try {
                z = f24529a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
