package com.meizu.cloud.pushsdk.c.g;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/g/k.class */
final class k {

    /* renamed from: a  reason: collision with root package name */
    private static j f24075a;
    private static long b;

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a() {
        synchronized (k.class) {
            try {
                if (f24075a != null) {
                    j jVar = f24075a;
                    f24075a = jVar.f;
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
                jVar.f = f24075a;
                jVar.f24074c = 0;
                jVar.b = 0;
                f24075a = jVar;
            } finally {
            }
        }
    }
}
