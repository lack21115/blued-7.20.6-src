package com.heytap.msp.mobad.api;

import com.opos.mobad.f.e;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f22226a;

    private a() {
    }

    public static e a() {
        if (f22226a == null) {
            synchronized (a.class) {
                try {
                    if (f22226a == null) {
                        f22226a = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f22226a;
    }
}
