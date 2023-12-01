package com.anythink.expressad.out;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/out/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static com.anythink.expressad.e.a f8070a;

    private g() {
    }

    public static com.anythink.expressad.e.a a() {
        if (f8070a == null) {
            synchronized (g.class) {
                try {
                    if (f8070a == null) {
                        f8070a = new com.anythink.expressad.e.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8070a;
    }
}
