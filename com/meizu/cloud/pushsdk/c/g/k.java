package com.meizu.cloud.pushsdk.c.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/g/k.class */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static j f10464a;
    private static long b;

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a() {
        synchronized (k.class) {
            try {
                if (f10464a != null) {
                    j jVar = f10464a;
                    f10464a = jVar.f;
                    jVar.f = null;
                    b -= 2048;
                    return jVar;
                }
                return new j();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar) {
        if (jVar.f != null || jVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.d) {
            return;
        }
        synchronized (k.class) {
            try {
                if (b + 2048 > 65536) {
                    return;
                }
                b += 2048;
                jVar.f = f10464a;
                jVar.f10463c = 0;
                jVar.b = 0;
                f10464a = jVar;
            } finally {
            }
        }
    }
}
