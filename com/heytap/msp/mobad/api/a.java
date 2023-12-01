package com.heytap.msp.mobad.api;

import com.opos.mobad.f.e;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f8618a;

    private a() {
    }

    public static e a() {
        if (f8618a == null) {
            synchronized (a.class) {
                try {
                    if (f8618a == null) {
                        f8618a = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8618a;
    }
}
