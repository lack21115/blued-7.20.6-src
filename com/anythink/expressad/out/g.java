package com.anythink.expressad.out;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/out/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static com.anythink.expressad.e.a f5230a;

    private g() {
    }

    public static com.anythink.expressad.e.a a() {
        if (f5230a == null) {
            synchronized (g.class) {
                try {
                    if (f5230a == null) {
                        f5230a = new com.anythink.expressad.e.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5230a;
    }
}
