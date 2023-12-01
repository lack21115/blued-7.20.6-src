package com.opos.mobad.f;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/c.class */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private static c f12446a;

    private c() {
    }

    public static final void b(Context context) {
        synchronized (c.class) {
            try {
                if (f12446a != null) {
                    f12446a.c();
                    f12446a = null;
                }
            } finally {
            }
        }
    }

    public static c d() {
        c cVar;
        c cVar2 = f12446a;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (c.class) {
            try {
                if (f12446a == null) {
                    f12446a = new c();
                }
                cVar = f12446a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public void a(Context context, String str, int i, boolean z, boolean z2) {
        com.opos.cmn.an.f.a.b("", "tourist mode = " + z2);
        Context applicationContext = context.getApplicationContext();
        a(applicationContext, (Integer) 1, (com.opos.mobad.ad.c) new com.opos.mobad.e(applicationContext, i));
        a(applicationContext, z);
    }
}
